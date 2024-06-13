package com.example.final_project_bank_application;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.*;
import java.util.Scanner;

public class Bank extends Application {

    //Variables or components of the GUI application
    Pane pne_base, pne_cards;
    Bank.Open_AccountPane pne_open_account;
    Bank.Validate_Account_IDPane pne_validate_account_ID;
    Bank.Perform_Account_TransactionPane pne_perform_account_transaction;
    Bank.Regular_Saving_AccountPane pne_regular_saving_account;
    Bank.Premium_Saving_AccountPane pne_premium_saving_account;
    Bank.Personal_Loan_AccountPane pne_personal_loan_account;
    Bank.Commercial_Loan_AccountPane pne_commercial_loan_account;
    Bank.MenuPane pne_menu;
    Bank.OutputPane pne_output;

    public void start(Stage stage) throws FileNotFoundException {
        pne_cards = new StackPane();
        pne_open_account = new Open_AccountPane();
        pne_validate_account_ID = new Validate_Account_IDPane();
        pne_perform_account_transaction = new Perform_Account_TransactionPane();
        pne_regular_saving_account = new Regular_Saving_AccountPane();
        pne_premium_saving_account = new Premium_Saving_AccountPane();
        pne_personal_loan_account = new Personal_Loan_AccountPane();
        pne_commercial_loan_account = new Commercial_Loan_AccountPane();
        pne_menu = new MenuPane();
        pne_output = new OutputPane();

        //Add the individual 'pages' to the card manager panel for easy page swaps
        pne_cards.getChildren().addAll(pne_validate_account_ID,pne_perform_account_transaction,pne_regular_saving_account,pne_premium_saving_account,pne_personal_loan_account,pne_commercial_loan_account,pne_open_account);

        //Add the card stack and the menu panels to the base panel for ideal layout
        pne_base = new VBox(7);
        pne_base.getChildren().addAll(pne_menu, pne_cards, pne_output);

        //Creating a scene object
        Scene scene = new Scene(pne_base, 1100, 600);

        //Setting the fill color to the scene
        scene.setFill(Color.GREENYELLOW);

        //Passing FileInputStream object as a parameter
        FileInputStream inputstream = new FileInputStream("Icons/Number-One-Banking-Icon.png");
        Image icon = new Image(inputstream);

        //Set stage icon
        stage.getIcons().add(icon);

        //Set stage title
        stage.setTitle("Number One Banking V1.0");

        //Adding scene to the stage
        stage.setScene(scene);

        //Displaying the contents of the stage
        stage.show();

    }//End of Bank constructor



    public static File accountsFiles = new File("Accounts Information's/Accounts Information's.dat");
    public static File accountsFilesIDs = new File("Accounts Information's/Accounts ID.dat");
    public static File customerFilesIDs = new File("Accounts Information's/Customer ID.dat");
    public static File arrayFilesPosition = new File("Accounts Information's/Array Position.dat");
    public static Account [] new_Account = new Account [10];
    public static String Account_ID_Gen, Custumer_ID_Gen;
    public  static int  account_position = -1;
    public String array_postion;
    public static int j = 0;
    public static int i;



// Write IDs to file

    /**
     * <h1>Write File Method</h1>
     * <p>Use to write IDs to file</p>
     *
     * @param acc_num the account number argument
     * @param custId the customer ID argument
     * @param array_postion the array postion argument
     */

    public static void writeFileIDs(String acc_num, String custId, String array_postion){

        if (acc_num != null) {
            try (PrintWriter pw = new PrintWriter(new FileWriter(accountsFilesIDs))) {
                pw.print(acc_num);
                pw.flush();
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }

        if(custId != null) {
            try (PrintWriter pw = new PrintWriter(new FileWriter(customerFilesIDs))) {
                pw.print(custId);
                pw.flush();
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }

        if(array_postion != null) {
            try (PrintWriter pw = new PrintWriter(new FileWriter(arrayFilesPosition))) {
                pw.print(array_postion);
                pw.flush();
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
;            }
        }

    }

// Write IDs to file ends


// Read IDs from file

    /**
     * <h1>Read File Method</h1>
     * <p>Use to read IDs from file</p>
     * @param accountsFilesIDs the account ID argument
     * @param customerFilesIDs the customer ID argument
     */

    public static void readFileIDs(File accountsFilesIDs, File customerFilesIDs){

        try(Scanner file_in = new Scanner(new File(String.valueOf(accountsFilesIDs)))){

            while(file_in.hasNext()){
                String ID = file_in.nextLine();
                Account.acc_gen= Integer.parseInt(ID)+7;
            }
        }catch(FileNotFoundException fnf){
            System.out.println(fnf.getMessage());
        }

        try(Scanner file_in = new Scanner(new File(String.valueOf(customerFilesIDs)))){

            while(file_in.hasNext()){
                String ID = file_in.nextLine();
                Customer.custId_gen = Integer.parseInt(ID)+1;

            }
        }catch(FileNotFoundException fnf){
            System.out.println(fnf.getMessage());
        }

        try(Scanner file_in = new Scanner(new File(String.valueOf(arrayFilesPosition)))){

            while(file_in.hasNext()){
                String pos = file_in.nextLine();
                j = Integer.parseInt(pos)+1;
            }
        }catch(FileNotFoundException fnf){
            System.out.println(fnf.getMessage());
        }

    }

 // Read IDs from file ends


// Write to file

    /**
     * <h1>Write To File Method</h1>
     * <p>Use to create new account or update information.</p>
     * @param fileName the file name argument
     * @param data the data argument
     */

    public static void writeFile (String fileName, Account[] data){

        /**
         * <p>Declare all variables the use of (All variables are declared outside of method)</p>
         */

        try(ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(fileName))){

            output.writeObject(data);

        }catch (FileNotFoundException ex){
            System.out.println("Error! Cannot find file: "+fileName);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

// write to file ends


// Read file

    /**
     * <h1>Read File Method</h1>
     * <p>Use to read from the file</p>
     * @param fileName the file name argument
     */

    public static void readFile(String fileName){

        /**
         * <p>Declare all variables the use of (All variables are declared outside of method)</p>
         */

        try(ObjectInputStream readStream = new ObjectInputStream(new FileInputStream(fileName))){

            while(true){

                new_Account = (Account[]) readStream.readObject();

            }

        } catch(ClassNotFoundException e){
            System.out.println(e.getMessage());
        } catch (FileNotFoundException e){
            System.out.println("Error! Cannot find file: "+fileName);
        } catch (IOException e){ if (e instanceof EOFException)
            System.out.println("Fail to load file: "+fileName+"\n"+"File may be empty or corrupted.\n ");
        }

    }

//  Read file ends


//  Open account pane

    /**
     * <h1>Open Account Pane</h1>
     * <p>Use to select the type of account.</p>
     */

    private class Open_AccountPane extends GridPane{

        RadioButton rbtn_regular_saving_account,rbtn_premium_saving_account,rbtn_personal_loan_account,rbtn_commercial_loan_account;
        ToggleGroup tg_account_selection;
        Text open_welcome;

        /**
         * <h1>Open Account Constructor</h1>
         */

        public Open_AccountPane(){

            //Initialize components for the 'page'
            tg_account_selection = new ToggleGroup();
            rbtn_regular_saving_account = new RadioButton("Regular Saving Account");
            rbtn_premium_saving_account = new RadioButton("Premium Saving Account");
            rbtn_personal_loan_account = new RadioButton("Personal Loan Account");
            rbtn_commercial_loan_account = new RadioButton("Commercial Loan Account");
            open_welcome = new Text("Please select an account type");


            //Set toggle group
            rbtn_regular_saving_account.setToggleGroup(tg_account_selection) ;
            rbtn_premium_saving_account.setToggleGroup(tg_account_selection) ;
            rbtn_personal_loan_account.setToggleGroup(tg_account_selection) ;
            rbtn_commercial_loan_account.setToggleGroup(tg_account_selection) ;


            //Set font
            rbtn_regular_saving_account.setFont(Font.font(null, FontWeight.BOLD, 12));
            rbtn_premium_saving_account.setFont(Font.font(null, FontWeight.BOLD, 12));
            rbtn_personal_loan_account.setFont(Font.font(null, FontWeight.BOLD, 12));
            rbtn_commercial_loan_account.setFont(Font.font(null, FontWeight.BOLD, 12));
            open_welcome.setFont(Font.font(null, FontWeight.BOLD, 15));
            open_welcome.setFill(Color.DARKSLATEBLUE);


            //Add listeners to the buttons
            tg_account_selection.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
                public void changed(ObservableValue changed, Toggle oldVal, Toggle newVal) {
                    if (newVal == null)
                        return;
                    // Cast newVal to RadioButton.
                    RadioButton rmi = (RadioButton) newVal;
                    if(rmi.getText().equals("Regular Saving Account")) {
                        pne_cards.getChildren().clear();
                        pne_cards.getChildren().add(pne_regular_saving_account);
                        pne_output.txa_output.appendText("\nYou have selected: Regular Saving Account\n");
                    }else if(rmi.getText().equals("Premium Saving Account")){
                        pne_cards.getChildren().clear();
                        pne_cards.getChildren().add(pne_premium_saving_account);
                        pne_output.txa_output.appendText("\nYou have selected: Premium Saving Account\n");
                    }else if(rmi.getText().equals("Personal Loan Account")){
                        pne_cards.getChildren().clear();
                        pne_cards.getChildren().add(pne_personal_loan_account);
                        pne_output.txa_output.appendText("\nYou have selected: Personal Loan Account\n");
                    }else if(rmi.getText().equals("Commercial Loan Account")){
                        pne_cards.getChildren().clear();
                        pne_cards.getChildren().add(pne_commercial_loan_account);
                        pne_output.txa_output.appendText("\nYou have selected: Commercial Loan Account\n");
                    }
                }
            });


            //Set colour of this panel
            this.setStyle("-fx-background-color: #aaaaaa");

            //Setting size for the pane
            this.setMinSize(450, 300);

            //Setting the padding
            this.setPadding(new Insets(10, 10, 10, 10));

            //Setting the vertical and horizontal gaps between the columns
            this.setVgap(7);
            this.setHgap(7);

            //Setting the Grid alignment
            this.setAlignment(Pos.CENTER);

            //Arranging all the nodes in the grid
            this.add(open_welcome, 0, 0, 2, 1);
            this.add(rbtn_regular_saving_account,1,3);
            this.add(rbtn_premium_saving_account,1,4);
            this.add(rbtn_personal_loan_account,1,5);
            this.add(rbtn_commercial_loan_account,1,6);
            rbtn_regular_saving_account.setPrefHeight(36);
            rbtn_regular_saving_account.setPrefWidth(180);
            rbtn_premium_saving_account.setPrefHeight(36);
            rbtn_premium_saving_account.setPrefWidth(180);
            rbtn_personal_loan_account.setPrefHeight(36);
            rbtn_personal_loan_account.setPrefWidth(180);
            rbtn_commercial_loan_account.setPrefHeight(36);
            rbtn_commercial_loan_account.setPrefWidth(180);
            this.setMinSize(90, 400);

        }
    }

// Open account pane ends


//  Regular saving account pane

    /**
     * <h1>Regular Saving Account Pane</h1>
     * <p>Use to create regular savings account.</p>
     */

    private class Regular_Saving_AccountPane extends GridPane{

        Button btn_create_account;
        TextField txt_fname,txt_lname,txt_address,txt_contact,txt_starting_balance,txt_identification_number,txt_identification_type;
        Label lbl_fname,lbl_lname,lbl_address,lbl_contact,lbl_starting_balance,lbl_identification_number,lbl_identification_type;
        Text open_welcome_regular_saving_account;

        /**
         * <h1>Regular Saving Account Constructor</h1>
         */

        public Regular_Saving_AccountPane(){

            //Initialize components for the 'page'
            lbl_fname = new Label("First Name (e.g. John): ");
            lbl_lname = new Label("Last Name (e.g. Doe): ");
            lbl_address = new Label("Address (e.g. #123-Henry-ST-Port-of-Spain): ");
            lbl_contact = new Label("Contact (e.g. 1868-333-3333): ");
            lbl_starting_balance = new Label("Starting Balance (e.g. 100.00): ");
            lbl_identification_number = new Label("Identification Number (e.g. 2888888888): ");
            lbl_identification_type = new Label("Identification Type (e.g. N for : National ID, D for : Drivers License, or B for : Birth Certificate): ");
            btn_create_account = new Button("Create Account");
            open_welcome_regular_saving_account = new Text("Regular Saving Account");


            //Create textfield
            txt_fname = new TextField();
            txt_lname = new TextField();
            txt_address = new TextField();
            txt_contact = new TextField();
            txt_starting_balance = new TextField();
            txt_identification_number = new TextField();
            txt_identification_type = new TextField();


            //Set textfield
            txt_fname.setMaxWidth(260);
            txt_fname.setMinWidth(260);
            txt_address.setMaxWidth(260);
            txt_address.setMinWidth(260);
            txt_contact.setMaxWidth(260);
            txt_contact.setMinWidth(260);
            txt_starting_balance.setMaxWidth(260);
            txt_starting_balance.setMinWidth(260);
            txt_identification_number.setMaxWidth(260);
            txt_identification_number.setMinWidth(260);
            txt_identification_type.setMaxWidth(260);
            txt_identification_type.setMinWidth(260);


            //Set font
            lbl_fname.setFont(Font.font(null, FontWeight.BOLD, 12));
            lbl_lname.setFont(Font.font(null, FontWeight.BOLD, 12));
            lbl_address.setFont(Font.font(null, FontWeight.BOLD, 12));
            lbl_contact.setFont(Font.font(null, FontWeight.BOLD, 12));
            lbl_starting_balance.setFont(Font.font(null, FontWeight.BOLD, 12));
            lbl_identification_number.setFont(Font.font(null, FontWeight.BOLD, 12));
            lbl_identification_type.setFont(Font.font(null, FontWeight.BOLD, 12));
            btn_create_account.setFont(Font.font(null, FontWeight.BOLD, 12));
            open_welcome_regular_saving_account.setFont(Font.font(null, FontWeight.BOLD, 15));
            open_welcome_regular_saving_account.setFill(Color.DARKSLATEBLUE);


            //Set button color
            btn_create_account.setStyle("-fx-background-color: LightGray;");


            //Add listeners to the buttons
            btn_create_account.setOnMouseEntered(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent e) {
                    btn_create_account.setStyle("-fx-background-color: #e5bb45;");
                }
            });

            btn_create_account.setOnMouseExited(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent e) {
                    btn_create_account.setStyle("-fx-background-color: LightGray ;");
                }
            });

            btn_create_account.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(javafx.scene.input.MouseEvent e) {
                    btn_create_account.setStyle("-fx-background-color: #dec05e ;");

                    String F_name = txt_fname.getText();
                    String L_name = txt_lname.getText();
                    String Address = txt_address.getText();
                    String Contact = txt_contact.getText();
                    String starting_balance = txt_starting_balance.getText();
                    String Identification_number = txt_identification_number.getText();
                    String identification_type = txt_identification_type.getText();

                    char Identification_type = identification_type.charAt(0);
                    double Starting_Balance = Double.parseDouble(starting_balance);

                    new_Account[j] = new RegularSavings(Starting_Balance, new IndividualCustomer(F_name, L_name, Address, Contact, Identification_number, Identification_type));

                    pne_output.txa_output.appendText("\nAccount was created successfully.\n");
                    pne_output.txa_output.appendText("\nCustomer ID: " + new_Account[j].getOwner().getCustId());
                    pne_output.txa_output.appendText("\nAccount ID: " + new_Account[j].getAcc_num());
                    pne_output.txa_output.appendText(new_Account[j].toString());
                    Account_ID_Gen = new_Account[j].getAcc_num();
                    Custumer_ID_Gen = new_Account[j].getOwner().getCustId();
                    array_postion = String.valueOf(j);
                    j++;

                }
            });


            //Set colour of this panel
            this.setStyle("-fx-background-color: #aaaaaa");

            //Setting size for the pane
            this.setMinSize(450, 300);

            //Setting the padding
            this.setPadding(new Insets(10, 10, 10, 10));

            //Setting the vertical and horizontal gaps between the columns
            this.setVgap(10);
            this.setHgap(10);

            //Setting the Grid alignment
            this.setAlignment(Pos.CENTER);

            //Arranging all the nodes in the grid
            this.add(open_welcome_regular_saving_account, 0, 0, 2, 1);
            this.add(lbl_fname, 0, 1);
            this.add(txt_fname, 1, 1);
            this.add(lbl_lname, 0, 2);
            this.add(txt_lname, 1, 2);
            this.add(lbl_address, 0, 3);
            this.add(txt_address, 1, 3);
            this.add(lbl_contact, 0,4);
            this.add(txt_contact, 1, 4);
            this.add(lbl_starting_balance, 0,5);
            this.add(txt_starting_balance, 1, 5);
            this.add(lbl_identification_number, 0,6);
            this.add(txt_identification_number, 1, 6);
            this.add(lbl_identification_type, 0,7);
            this.add(txt_identification_type, 1, 7);
            this.add(btn_create_account,1,8);
            this.setMinSize(90, 400);

        }
    }

// Regular saving account pane ends


// Premium saving account

    /**
     * <h1>Premium Saving Account Pane</h1>
     * <p>Use to create premium saving account.</p>
     */

    private class Premium_Saving_AccountPane extends GridPane{

        Button btn_create_account;
        TextField txt_fname,txt_lname,txt_address,txt_contact,txt_starting_balance,txt_identification_number,txt_identification_type,txt_interest_rate;
        Label lbl_fname,lbl_lname,lbl_address,lbl_contact,lbl_starting_balance,lbl_identification_number,lbl_identification_type,lbl_interest_rate;
        Text open_welcome_premium_saving_account;


        /**
         * <h1>Premium Saving Account Pane</h1>
         */

        public Premium_Saving_AccountPane(){

            //Initialize components for the 'page'
            lbl_fname = new Label("First Name (e.g. John): ");
            lbl_lname = new Label("Last Name (e.g. Doe): ");
            lbl_address = new Label("Address (e.g. #123-Henry-ST-Port-of-Spain): ");
            lbl_contact = new Label("Contact (e.g. 1868-333-3333): ");
            lbl_starting_balance = new Label("Starting Balance (e.g. 100.00): ");
            lbl_identification_number = new Label("Identification Number (e.g. 2888888888): ");
            lbl_identification_type = new Label("Identification Type (e.g. N for : National ID, D for : Drivers License, or B for : Birth Certificate): ");
            lbl_interest_rate = new Label("Interest Rate (e.g. .01 = 1% ): ");
            btn_create_account = new Button("Create Account");
            open_welcome_premium_saving_account = new Text("Premium Saving Account");


            //Create textfield
            txt_fname = new TextField();
            txt_lname = new TextField();
            txt_address = new TextField();
            txt_contact = new TextField();
            txt_starting_balance = new TextField();
            txt_identification_number = new TextField();
            txt_identification_type = new TextField();
            txt_interest_rate = new TextField();


            //Set textfield
            txt_fname.setMaxWidth(260);
            txt_fname.setMinWidth(260);
            txt_address.setMaxWidth(260);
            txt_address.setMinWidth(260);
            txt_contact.setMaxWidth(260);
            txt_contact.setMinWidth(260);
            txt_starting_balance.setMaxWidth(260);
            txt_starting_balance.setMinWidth(260);
            txt_identification_number.setMaxWidth(260);
            txt_identification_number.setMinWidth(260);
            txt_identification_type.setMaxWidth(260);
            txt_identification_type.setMinWidth(260);
            txt_interest_rate.setMaxWidth(260);
            txt_interest_rate.setMinWidth(260);


            //Set font
            lbl_fname.setFont(Font.font(null, FontWeight.BOLD, 12));
            lbl_lname.setFont(Font.font(null, FontWeight.BOLD, 12));
            lbl_address.setFont(Font.font(null, FontWeight.BOLD, 12));
            lbl_contact.setFont(Font.font(null, FontWeight.BOLD, 12));
            lbl_starting_balance.setFont(Font.font(null, FontWeight.BOLD, 12));
            lbl_identification_number.setFont(Font.font(null, FontWeight.BOLD, 12));
            lbl_identification_type.setFont(Font.font(null, FontWeight.BOLD, 12));
            lbl_interest_rate.setFont(Font.font(null, FontWeight.BOLD, 12));
            btn_create_account.setFont(Font.font(null, FontWeight.BOLD, 12));
            open_welcome_premium_saving_account.setFont(Font.font(null, FontWeight.BOLD, 15));
            open_welcome_premium_saving_account.setFill(Color.DARKSLATEBLUE);


            //Set button color
            btn_create_account.setStyle("-fx-background-color: LightGray;");


            //Add listeners to the buttons
            btn_create_account.setOnMouseEntered(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent e) {
                    btn_create_account.setStyle("-fx-background-color: #e5bb45;");
                }
            });

            btn_create_account.setOnMouseExited(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent e) {
                    btn_create_account.setStyle("-fx-background-color: LightGray ;");
                }
            });

            btn_create_account.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent e) {

                    //Set button color
                    btn_create_account.setStyle("-fx-background-color: #dec05e ;");

                    String F_name = txt_fname.getText();
                    String L_name = txt_lname.getText();
                    String Address = txt_address.getText();
                    String Contact = txt_contact.getText();
                    String starting_balance = txt_starting_balance.getText();
                    String Identification_number = txt_identification_number.getText();
                    String identification_type = txt_identification_type.getText();
                    String interest_rate = txt_interest_rate.getText();

                    char Identification_type = identification_type.charAt(0);
                    double Starting_Balance = Double.parseDouble(starting_balance);
                    double Interest_Rate =  Double.parseDouble(interest_rate);

                    new_Account[j] = new PremiumSavings(Starting_Balance, new IndividualCustomer(F_name, L_name, Address, Contact, Identification_number, Identification_type), Interest_Rate);

                    pne_output.txa_output.appendText("\nAccount was created successfully.\n");
                    pne_output.txa_output.appendText("\nCustomer ID: "+new_Account[j].getOwner().getCustId());
                    pne_output.txa_output.appendText("\nAccount ID: "+new_Account[j].getAcc_num());
                    pne_output.txa_output.appendText(new_Account[j].toString());
                    Account_ID_Gen = new_Account[j].getAcc_num();
                    Custumer_ID_Gen = new_Account[j].getOwner().getCustId();
                    array_postion = String.valueOf(j);
                    j++;

                }
            });


            //set colour of this panel
            this.setStyle("-fx-background-color: #aaaaaa");

            //Setting size for the pane
            this.setMinSize(450, 300);

            //Setting the padding
            this.setPadding(new Insets(10, 10, 10, 10));

            //Setting the vertical and horizontal gaps between the columns
            this.setVgap(10);
            this.setHgap(10);

            //Setting the Grid alignment
            this.setAlignment(Pos.CENTER);

            //Arranging all the nodes in the grid
            this.add(open_welcome_premium_saving_account, 0, 0, 2, 1);
            this.add(lbl_fname, 0, 1);
            this.add(txt_fname, 1, 1);
            this.add(lbl_lname, 0, 2);
            this.add(txt_lname, 1, 2);
            this.add(lbl_address, 0, 3);
            this.add(txt_address, 1, 3);
            this.add(lbl_contact, 0,4);
            this.add(txt_contact, 1, 4);
            this.add(lbl_starting_balance, 0,5);
            this.add(txt_starting_balance, 1, 5);
            this.add(lbl_identification_number, 0,6);
            this.add(txt_identification_number, 1, 6);
            this.add(lbl_identification_type, 0,7);
            this.add(txt_identification_type, 1, 7);
            this.add(lbl_interest_rate, 0,8);
            this.add(txt_interest_rate, 1, 8);
            this.add(btn_create_account,1,9);
            this.setMinSize(90, 400);

        }
    }

//  Premium saving account ends


//  Personal loan account

    /**
     * <h1>Personal Loan Account Pane</h1>
     * <p>Use to create personal loan account.</p>
     */

    private class Personal_Loan_AccountPane extends GridPane{

        Button btn_create_account;
        TextField txt_fname,txt_lname,txt_address,txt_contact,txt_identification_number,txt_identification_type,txt_interest_rate,txt_principal,txt_installment;
        Label lbl_fname,lbl_lname,lbl_address,lbl_contact,lbl_identification_number,lbl_identification_type,lbl_interest_rate,lbl_principal,lbl_installment;
        Text open_welcome_personal_loan_account;

        /**
         * <h1>Personal Loan Account Constructor</h1>
         */

        public Personal_Loan_AccountPane(){

            //Initialize components for the 'page'
            lbl_fname = new Label("First Name (e.g. John): ");
            lbl_lname = new Label("Last Name (e.g. Doe): ");
            lbl_address = new Label("Address (e.g. #123-Henry-ST-Port-of-Spain): ");
            lbl_contact = new Label("Contact (e.g. 1868-333-3333): ");
            lbl_identification_number = new Label("Identification Number (e.g. 2888888888): ");
            lbl_identification_type = new Label("Identification Type (e.g. N for : National ID, D for : Drivers License, or B for : Birth Certificate): ");
            lbl_interest_rate = new Label("Interest Rate (e.g. .01 = 1% ): ");
            lbl_principal = new Label("Principal (e.g. 1000.00): ");
            lbl_installment = new Label("Installment (e.g. 1000.00): ");
            btn_create_account = new Button("Create Account");
            open_welcome_personal_loan_account = new Text("Personal Loan Account");


            //Create textfield
            txt_fname = new TextField();
            txt_lname = new TextField();
            txt_address = new TextField();
            txt_contact = new TextField();
            txt_identification_number = new TextField();
            txt_identification_type = new TextField();
            txt_interest_rate = new TextField();
            txt_principal = new TextField();
            txt_installment = new TextField();


            //Set textfield
            txt_fname.setMaxWidth(260);
            txt_fname.setMinWidth(260);
            txt_address.setMaxWidth(260);
            txt_address.setMinWidth(260);
            txt_contact.setMaxWidth(260);
            txt_contact.setMinWidth(260);
            txt_identification_number.setMaxWidth(260);
            txt_identification_number.setMinWidth(260);
            txt_identification_type.setMaxWidth(260);
            txt_identification_type.setMinWidth(260);
            txt_interest_rate.setMaxWidth(260);
            txt_interest_rate.setMinWidth(260);


            //Set font
            lbl_fname.setFont(Font.font(null, FontWeight.BOLD, 12));
            lbl_lname.setFont(Font.font(null, FontWeight.BOLD, 12));
            lbl_address.setFont(Font.font(null, FontWeight.BOLD, 12));
            lbl_contact.setFont(Font.font(null, FontWeight.BOLD, 12));
            lbl_identification_number.setFont(Font.font(null, FontWeight.BOLD, 12));
            lbl_identification_type.setFont(Font.font(null, FontWeight.BOLD, 12));
            lbl_interest_rate.setFont(Font.font(null, FontWeight.BOLD, 12));
            lbl_principal.setFont(Font.font(null, FontWeight.BOLD, 12));
            lbl_installment.setFont(Font.font(null, FontWeight.BOLD, 12));
            btn_create_account.setFont(Font.font(null, FontWeight.BOLD, 12));
            open_welcome_personal_loan_account.setFont(Font.font(null, FontWeight.BOLD, 15));
            open_welcome_personal_loan_account.setFill(Color.DARKSLATEBLUE);

            //Set button color
            btn_create_account.setStyle("-fx-background-color: LightGray;");

            //Add listeners to the buttons
            btn_create_account.setOnMouseEntered(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent e) {
                    btn_create_account.setStyle("-fx-background-color: #e5bb45;");
                }
            });

            btn_create_account.setOnMouseExited(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent e) {
                    btn_create_account.setStyle("-fx-background-color: LightGray ;");
                }
            });

            btn_create_account.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent e) {

                    //Set button color
                    btn_create_account.setStyle("-fx-background-color: #dec05e ;");

                    String F_name = txt_fname.getText();
                    String L_name = txt_lname.getText();
                    String Address = txt_address.getText();
                    String Contact = txt_contact.getText();
                    String Identification_number = txt_identification_number.getText();
                    String identification_type = txt_identification_type.getText();
                    String interest_rate = txt_interest_rate.getText();
                    String principal = txt_principal.getText();
                    String installment = txt_installment.getText();

                    char Identification_type = identification_type.charAt(0);
                    double Starting_Balance = Double.parseDouble(principal);
                    double Interest_Rate =  Double.parseDouble(interest_rate);
                    double Principal =  Double.parseDouble(principal);
                    double Installment =  Double.parseDouble(installment);

                    new_Account[i] = new PersonalLoan(Starting_Balance, new IndividualCustomer(F_name, L_name, Address, Contact, Identification_number, Identification_type), Principal, Installment, Interest_Rate);

                    pne_output.txa_output.appendText("\nAccount was created successfully.\n");
                    pne_output.txa_output.appendText("\nCustomer ID: "+new_Account[j].getOwner().getCustId());
                    pne_output.txa_output.appendText("\nAccount ID: "+new_Account[j].getAcc_num());
                    pne_output.txa_output.appendText(new_Account[j].toString());
                    Account_ID_Gen = new_Account[j].getAcc_num();
                    Custumer_ID_Gen = new_Account[j].getOwner().getCustId();
                    array_postion = String.valueOf(j);
                    j++;

                }
            });


            //Set colour of this panel
            this.setStyle("-fx-background-color: #aaaaaa");

            //Setting size for the pane
            this.setMinSize(450, 300);

            //Setting the padding
            this.setPadding(new Insets(10, 10, 10, 10));

            //Setting the vertical and horizontal gaps between the columns
            this.setVgap(10);
            this.setHgap(10);

            //Setting the Grid alignment
            this.setAlignment(Pos.CENTER);

            //Arranging all the nodes in the grid
            this.add(open_welcome_personal_loan_account, 0, 0, 2, 1);
            this.add(lbl_fname, 0, 1);
            this.add(txt_fname, 1, 1);
            this.add(lbl_lname, 0, 2);
            this.add(txt_lname, 1, 2);
            this.add(lbl_address, 0, 3);
            this.add(txt_address, 1, 3);
            this.add(lbl_contact, 0,4);
            this.add(txt_contact, 1, 4);
            this.add(lbl_identification_number, 0,5);
            this.add(txt_identification_number, 1, 5);
            this.add(lbl_identification_type, 0,6);
            this.add(txt_identification_type, 1, 6);
            this.add(lbl_interest_rate, 0,7);
            this.add(txt_interest_rate, 1, 7);
            this.add(lbl_principal,0,8);
            this.add(txt_principal, 1, 8);
            this.add(lbl_installment,0,9);
            this.add(txt_installment, 1, 9);
            this.add(btn_create_account,1,10);

        }
    }

// Personal loan account ends


// Commercial loan account pane

    /**
     * <h1>Commercial Loan Account Pane</h1>
     * <p>Use to create commercial loan account.</p>
     */

    private class Commercial_Loan_AccountPane extends GridPane{

        Button btn_create_account;
        TextField txt_business_name,txt_address,txt_contact,txt_business_identification_number,txt_identification_type,txt_interest_rate,txt_principal,txt_installment,txt_manager_name;
        Label lbl_business_name,lbl_address,lbl_contact,lbl_business_identification_number,lbl_identification_type,lbl_interest_rate,lbl_principal,lbl_installment,lbl_manager_name;
        Text open_welcome_commercial_loan_account;

        /**
         * <h1>Commercial Loan Account Constructor</h1>
         */

        public Commercial_Loan_AccountPane(){

            //Initialize components for the 'page'
            lbl_business_name = new Label("Business Name (e.g. Number One Banking): ");
            lbl_address = new Label("Address (e.g. #123-Henry-ST-Port-of-Spain): ");
            lbl_contact = new Label("Contact (e.g. 1868-333-3333): ");
            lbl_business_identification_number = new Label("Identification Number (e.g. 2888888888): ");
            lbl_identification_type = new Label("Identification Type (e.g. S for : Sole Trader, P for : Partnership, or L for : Limited Liability): ");
            lbl_interest_rate = new Label("Interest Rate (e.g. .01 = 1% ): ");
            lbl_principal = new Label("Principal (e.g. 1000.00): ");
            lbl_installment = new Label("Installment (e.g. 1000.00): ");
            lbl_manager_name = new Label("Manager Name (e.g. John Doe): ");
            btn_create_account = new Button("Create Account");
            open_welcome_commercial_loan_account = new Text("Commercial Loan Account");


            //Create textfield
            txt_business_name = new TextField();
            txt_address = new TextField();
            txt_contact = new TextField();
            txt_business_identification_number = new TextField();
            txt_identification_type = new TextField();
            txt_interest_rate = new TextField();
            txt_principal = new TextField();
            txt_installment = new TextField();
            txt_manager_name = new TextField();


            //Set textfield
            txt_business_name.setMaxWidth(260);
            txt_business_name.setMinWidth(260);
            txt_address.setMaxWidth(260);
            txt_address.setMinWidth(260);
            txt_contact.setMaxWidth(260);
            txt_contact.setMinWidth(260);
            txt_business_identification_number.setMaxWidth(260);
            txt_business_identification_number.setMinWidth(260);
            txt_identification_type.setMaxWidth(260);
            txt_identification_type.setMinWidth(260);
            txt_interest_rate.setMaxWidth(260);
            txt_principal.setMaxWidth(260);
            txt_principal.setMinWidth(260);
            txt_installment.setMaxWidth(260);
            txt_installment.setMinWidth(260);
            txt_manager_name.setMaxWidth(260);
            txt_manager_name.setMinWidth(260);


            //Set button color
            btn_create_account.setStyle("-fx-background-color: LightGray;");


            //Set font
            lbl_business_name.setFont(Font.font(null, FontWeight.BOLD, 12));
            lbl_address.setFont(Font.font(null, FontWeight.BOLD, 12));
            lbl_contact.setFont(Font.font(null, FontWeight.BOLD, 12));
            lbl_business_identification_number.setFont(Font.font(null, FontWeight.BOLD, 12));
            lbl_identification_type.setFont(Font.font(null, FontWeight.BOLD, 12));
            lbl_interest_rate.setFont(Font.font(null, FontWeight.BOLD, 12));
            lbl_principal.setFont(Font.font(null, FontWeight.BOLD, 12));
            lbl_installment.setFont(Font.font(null, FontWeight.BOLD, 12));
            lbl_manager_name.setFont(Font.font(null, FontWeight.BOLD, 12));
            btn_create_account.setFont(Font.font(null, FontWeight.BOLD, 12));
            open_welcome_commercial_loan_account.setFont(Font.font(null, FontWeight.BOLD, 15));
            open_welcome_commercial_loan_account.setFill(Color.DARKSLATEBLUE);




            //Add listeners to the buttons
            btn_create_account.setOnMouseEntered(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent e) {
                    btn_create_account.setStyle("-fx-background-color: #e5bb45;");
                }
            });

            btn_create_account.setOnMouseExited(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent e) {
                    btn_create_account.setStyle("-fx-background-color: LightGray ;");
                }
            });

            btn_create_account.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent e) {

                    //Set button color
                    btn_create_account.setStyle("-fx-background-color: #dec05e ;");

                    String Business_Name = txt_business_name.getText();
                    String Address = txt_address.getText();
                    String Contact = txt_contact.getText();
                    String Business_registration_Number = txt_business_identification_number.getText();
                    String identification_type = txt_identification_type.getText();
                    String interest_rate = txt_interest_rate.getText();
                    String principal = txt_principal.getText();
                    String installment = txt_installment.getText();
                    String Manager_Name = txt_manager_name.getText();

                    char Identification_type = identification_type.charAt(0);
                    double Starting_Balance = Double.parseDouble(principal);
                    double Interest_Rate =  Double.parseDouble(interest_rate);
                    double Principal =  Double.parseDouble(principal);
                    double Installment =  Double.parseDouble(installment);

                    new_Account[j] = new CommercialLoan(Starting_Balance, new CommercialCustomer(Address, Contact, Business_registration_Number, Business_Name, Identification_type), Principal, Interest_Rate, Installment, Manager_Name);

                    pne_output.txa_output.appendText("\nAccount was created successfully.\n");
                    pne_output.txa_output.appendText("\nCustomer ID: "+new_Account[j].getOwner().getCustId());
                    pne_output.txa_output.appendText("\nAccount ID: "+new_Account[j].getAcc_num());
                    pne_output.txa_output.appendText(new_Account[j].toString());
                    Account_ID_Gen = new_Account[j].getAcc_num();
                    Custumer_ID_Gen = new_Account[j].getOwner().getCustId();
                    array_postion = String.valueOf(j);
                    j++;

                }
            });


            //Set colour of this panel
            this.setStyle("-fx-background-color: #aaaaaa");

            //Setting size for the pane
            this.setMinSize(450, 300);

            //Setting the padding
            this.setPadding(new Insets(10, 10, 10, 10));

            //Setting the vertical and horizontal gaps between the columns
            this.setVgap(10);
            this.setHgap(10);

            //Setting the Grid alignment
            this.setAlignment(Pos.CENTER);

            //Arranging all the nodes in the grid
            this.add(open_welcome_commercial_loan_account, 0, 0, 2, 1);
            this.add(lbl_business_name, 0, 1);
            this.add(txt_business_name, 1, 1);
            this.add(lbl_address, 0, 2);
            this.add(txt_address, 1, 2);
            this.add(lbl_contact, 0,3);
            this.add(txt_contact, 1, 3);
            this.add(lbl_business_identification_number, 0,4);
            this.add(txt_business_identification_number, 1, 4);
            this.add(lbl_identification_type, 0,5);
            this.add(txt_identification_type, 1, 5);
            this.add(lbl_interest_rate, 0,6);
            this.add(txt_interest_rate, 1, 6);
            this.add(lbl_principal,0,7);
            this.add(txt_principal, 1, 7);
            this.add(lbl_installment,0,8);
            this.add(txt_installment, 1, 8);
            this.add(lbl_manager_name,0,9);
            this.add(txt_manager_name, 1, 9);
            this.add(btn_create_account,1,10);

        }
    }

// Commercial loan account pane ends


// Validate Account Pane

    /**
     * <h1>Validate Account ID Pane</h1>
     * <p>Use to validate account ID. </p>
     */

    public class Validate_Account_IDPane extends GridPane{

        Button btn_validate_account_ID;
        TextField txt_validate_account_ID;
        Label lbl_validate_account_ID;
        Text validate_account_ID_welcome;

        /**
         * <h1>Validate Account ID Constructor</h1>
         */

        public Validate_Account_IDPane(){

            //Initialize components for the 'page'
            lbl_validate_account_ID = new Label("Account ID");
            btn_validate_account_ID= new Button("Search");
            validate_account_ID_welcome = new Text("Please enter account ID before transaction");

            //Create textfield
            txt_validate_account_ID = new TextField();


            //Set font
            lbl_validate_account_ID.setFont(Font.font(null, FontWeight.BOLD, 12));
            btn_validate_account_ID.setFont(Font.font(null, FontWeight.BOLD, 12));
            validate_account_ID_welcome.setFont(Font.font(null, FontWeight.BOLD, 14));
            validate_account_ID_welcome.setFill(Color.DARKSLATEBLUE);


            //Set button color
            btn_validate_account_ID.setStyle("-fx-background-color: LightGray;");


            //Add listeners to the buttons
            btn_validate_account_ID.setOnMouseEntered(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent e) {
                    btn_validate_account_ID.setStyle("-fx-background-color: #1E90FF ");
                }
            });

            btn_validate_account_ID.setOnMouseExited(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent e) {
                    btn_validate_account_ID.setStyle("-fx-background-color: LightGray;");
                }
            });

            btn_validate_account_ID.setOnMouseClicked(new EventHandler<MouseEvent>() {

                @Override
                public void handle(MouseEvent e) {

                    //Set button color
                    btn_validate_account_ID.setStyle("-fx-background-color: #6495ED;");

                    String Validate_Account_ID = txt_validate_account_ID.getText();

                        for (int i = 0; i < new_Account.length; i++){
                            if (new_Account[i] != null) {
                                if (Validate_Account_ID.equals(new_Account[i].getAcc_num())){
                                    account_position = i;
                                    break;
                                }
                            }
                        }if (account_position != -1 && Validate_Account_ID.equals(new_Account[account_position].getAcc_num())){
                            pne_output.txa_output.appendText("\nThis account belongs to:\n "+ new_Account[account_position].getOwner());
                            pne_cards.getChildren().clear();
                            pne_cards.getChildren().add(pne_perform_account_transaction);
                        }else{
                            pne_output.txa_output.appendText("\nInvalid! Account does not exist.\n");
                        }

                }
            });


            //Set colour of this panel
            this.setStyle("-fx-background-color: #aaaaaa");

            //Setting size for the pane
            this.setMinSize(450, 300);

            //Setting the padding
            this.setPadding(new Insets(10, 10, 10, 10));

            //Setting the vertical and horizontal gaps between the columns
            this.setVgap(7);
            this.setHgap(7);

            //Setting the Grid alignment
            this.setAlignment(Pos.CENTER);

            //Arranging all the nodes in the grid
            this.add(validate_account_ID_welcome, 0, 0, 2, 1);
            this.add(lbl_validate_account_ID, 0, 1);
            this.add(txt_validate_account_ID, 1, 1);
            this.add(btn_validate_account_ID,2,1);
            this.setMinSize(90, 400);

        }
    }

// Validate account pane close


//  Perform account transaction pane

    /**
     * <h1>Perform Account Transaction Pane</h1>
     * <p>Use to perform an account transaction.</p>
     */

    public class Perform_Account_TransactionPane extends GridPane{

        Button btn_withdrawal_amount,btn_deposit_amount,btn_payment_amount,btn_account_inquiry;
        TextField txt_withdrawal_amount,txt_deposit_amount,txt_payment_amount;
        Label lbl_withdrawal_amount,lbl_deposit_amount,lbl_payment_amount;
        Text perform_account_transaction_welcome;

        /**
         * <h1>Perform Account Transaction Constructor</h1>
         */

        public Perform_Account_TransactionPane(){

            //Initialize components for the 'page'
            lbl_withdrawal_amount = new Label("Withdrawal Amount");
            lbl_deposit_amount = new Label("Deposit Amount");
            lbl_payment_amount = new Label("Payment Amount");
            btn_withdrawal_amount = new Button("Withdraw");
            btn_deposit_amount = new Button("Deposit");
            btn_payment_amount = new Button("Payment");
            btn_account_inquiry = new Button("Account Inquiry");
            perform_account_transaction_welcome = new Text("Please select transaction");


            //Create textfield
            txt_withdrawal_amount = new TextField();
            txt_deposit_amount = new TextField();
            txt_payment_amount = new TextField();


            //Set font
            lbl_withdrawal_amount.setFont(Font.font(null, FontWeight.BOLD, 12));
            lbl_deposit_amount.setFont(Font.font(null, FontWeight.BOLD, 12));
            lbl_payment_amount.setFont(Font.font(null, FontWeight.BOLD, 12));
            btn_withdrawal_amount.setFont(Font.font(null, FontWeight.BOLD, 12));
            btn_deposit_amount.setFont(Font.font(null, FontWeight.BOLD, 12));
            btn_payment_amount.setFont(Font.font(null, FontWeight.BOLD, 12));
            btn_account_inquiry.setFont(Font.font(null, FontWeight.BOLD, 12));
            perform_account_transaction_welcome.setFont(Font.font(null, FontWeight.BOLD, 14));
            perform_account_transaction_welcome.setFill(Color.DARKSLATEBLUE);


            //Set button color
            btn_account_inquiry.setStyle("-fx-background-color: LightGray;");
            btn_withdrawal_amount.setStyle("-fx-background-color: LightGray;");
            btn_deposit_amount.setStyle("-fx-background-color: LightGray;");
            btn_payment_amount.setStyle("-fx-background-color: LightGray;");
            btn_account_inquiry.setStyle("-fx-background-color: LightGray;");


            //Add listeners to the buttons
            btn_withdrawal_amount.setOnMouseEntered(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent e) {
                    btn_withdrawal_amount.setStyle("-fx-background-color: #1E90FF ");
                }
            });

            btn_withdrawal_amount.setOnMouseExited(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent e) {
                    btn_withdrawal_amount.setStyle("-fx-background-color: LightGray;");
                }
            });

            btn_deposit_amount.setOnMouseEntered(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent e) {
                    btn_deposit_amount.setStyle("-fx-background-color: #1E90FF ");
                }
            });

            btn_deposit_amount.setOnMouseExited(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent e) {
                    btn_deposit_amount.setStyle("-fx-background-color: LightGray;");
                }
            });

            btn_payment_amount.setOnMouseEntered(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent e) {
                    btn_payment_amount.setStyle("-fx-background-color: #1E90FF ");
                }
            });

            btn_payment_amount.setOnMouseExited(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent e) {
                    btn_payment_amount.setStyle("-fx-background-color: LightGray;");
                }
            });

            btn_account_inquiry.setOnMouseEntered(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent e) {btn_account_inquiry.setStyle("-fx-background-color: #e5bb45;");}
            });

            btn_account_inquiry.setOnMouseExited(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent e) {btn_account_inquiry.setStyle("-fx-background-color: LightGray ;");}
            });

            btn_account_inquiry.setOnMouseClicked(new EventHandler<MouseEvent>() {

                @Override
                public void handle(javafx.scene.input.MouseEvent e) {

                    //Set button color
                    btn_account_inquiry.setStyle("-fx-background-color: #dec05e ;");
                    pne_output.txa_output.appendText ("\n\nAccount Inquiry:\n");
                    pne_output.txa_output.appendText (new_Account[account_position].toString()+"\n");
                }
            });

            btn_withdrawal_amount.setOnMouseClicked(new EventHandler<MouseEvent>() {

                @Override
                public void handle(MouseEvent e) {
                    btn_withdrawal_amount.setStyle("-fx-background-color: #6495ED;");

                    String withdrawal_amount = txt_withdrawal_amount.getText();

                    double Withdrawal_Amount= Double.parseDouble(withdrawal_amount);

                    if (new_Account[account_position].getBalance() < Withdrawal_Amount){
                        try {
                            throw new InsufficientFundsException();
                        } catch (InsufficientFundsException ex) {
                            pne_output.txa_output.appendText("\n"+ex.getMessage()+"\n");
                        }
                    }else{
                        try {
                            new_Account[account_position].withdraw(Withdrawal_Amount);
                            if(new_Account[account_position].getOwner().getFname() != null) {
                                pne_output.txa_output.appendText("\nYou have just withdraw: " + withdrawal_amount + " from: " + new_Account[account_position].getOwner().getFname() + " " + new_Account[account_position].getOwner().getLname() + " account.\n");
                            }else{
                                pne_output.txa_output.appendText("\n\nYou have just withdraw: " + withdrawal_amount + " from: " +new_Account[account_position].getOwner());
                            }
                        } catch (InsufficientFundsException ex) {
                            pne_output.txa_output.appendText("\n"+ex.getMessage()+"\n");
                        }
                    }
                }
            });

            btn_deposit_amount.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent e) {
                    btn_deposit_amount.setStyle("-fx-background-color: #6495ED;");

                    String deposit_dmount = txt_deposit_amount.getText();

                    double Deposit_Amount = Double.parseDouble(deposit_dmount);

                    if (Deposit_Amount < 1) {

                        pne_output.txa_output.appendText("\nPlease enter a deposit amount that is greater than zero.\n");

                    }else{
                        new_Account[account_position].deposit(Deposit_Amount);

                        if(new_Account[account_position].getOwner().getFname() != null) {

                            pne_output.txa_output.appendText("\nYou have just deposit: "+deposit_dmount+" into: "+new_Account[account_position].getOwner().getFname()+" "+new_Account[account_position].getOwner().getLname()+" account.\n");
                        }else{
                            pne_output.txa_output.appendText("\n\nYou have just deposit: " +deposit_dmount+ " into: " +new_Account[account_position].getOwner());
                        }

                    }

                }
            });

            btn_payment_amount.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent e) {

                    btn_payment_amount.setStyle("-fx-background-color: #6495ED;");

                    String payment_amount = txt_payment_amount.getText();

                    double Payment_Amount = Double.parseDouble(payment_amount);

                        try {
                            new_Account[account_position].payment(Payment_Amount);
                            if(new_Account[account_position].getOwner().getFname() != null) {
                                pne_output.txa_output.appendText("\nYou have just made a payment of: "+payment_amount+" to: "+new_Account[account_position].getOwner().getFname()+" "+new_Account[account_position].getOwner().getLname()+" account.\n");
                            }else{
                                pne_output.txa_output.appendText("\n\nYou have just made a payment of: " +payment_amount+ " to: " +new_Account[account_position].getOwner());
                            }

                        } catch (PartialPaymentException ex) {
                            pne_output.txa_output.appendText("\n"+ex.getMessage()+"\n");
                        }

                }
            });


            this.setStyle("-fx-background-color: #aaaaaa");

            //Setting size for the pane
            this.setMinSize(450, 300);

            //Setting the padding
            this.setPadding(new Insets(10, 10, 10, 10));

            //Setting the vertical and horizontal gaps between the columns
            this.setVgap(7);
            this.setHgap(7);

            //Setting the Grid alignment
            this.setAlignment(Pos.CENTER); //Set colour of this panel

            //Arranging all the nodes in the grid
            this.add(perform_account_transaction_welcome, 0, 0, 2, 1);
            this.add(lbl_withdrawal_amount, 0, 1);
            this.add(txt_withdrawal_amount, 1, 1);
            this.add(btn_withdrawal_amount,2,1);
            this.add(lbl_deposit_amount, 0, 2);
            this.add(txt_deposit_amount, 1, 2);
            this.add(btn_deposit_amount,2,2);
            this.add(lbl_payment_amount, 0, 3);
            this.add(txt_payment_amount, 1, 3);
            this.add(btn_payment_amount,2,3);
            this.add(btn_account_inquiry,1,5);
            this.setMinSize(90, 400);

        }
    }

// Perform account transaction pane ends


// Output pane

    /**
     * <h1>Output Pane</h1>
     * <p>Use to output account information to the textarea.</p>
     */

    private class OutputPane extends HBox{

        TextArea txa_output;

        /**
         * <h1>Output Pane Constructor</h1>
         */

        public OutputPane(){

            //Initialize components for the 'page'
            txa_output = new TextArea();

            //Set font
            txa_output.setFont(Font.font(null, FontWeight.BOLD, 12));

            //Set textarea height and width
            txa_output.setPrefHeight(180);
            txa_output.setPrefWidth(1360);

            //Set colour of this panel
            this.setStyle("-fx-background-color:White ");

            //Set alignment
            this.setAlignment(Pos.CENTER);
            this.getChildren().addAll(txa_output);

        }

    }

// Output pane ends


//  Menu pane

    /**
     * <h1>Menue Pane</h1>
     * <p>Use to select between open account, perform transaction, display all accounts, and exit/save.</p>
      */

    private class MenuPane extends HBox {

        Button  btn_open_account, btn_perform_transaction, btn_display_all_accounts, btn_close;

        /**
         * <h1>Menu Pane Constructor</h1>
         * @throws FileNotFoundException
         */

        public MenuPane() throws FileNotFoundException {

            FileInputStream inputstream = new FileInputStream("Icons/Number-One-Banking-Logo.png");
            Image image = new Image(inputstream);
            //Create the image view
            ImageView imageView = new ImageView();
            //Set image to the image view
            imageView.setImage(image);
            //Set image width
            imageView.setFitWidth(100);
            imageView.setPreserveRatio(true);


            //Initialize button components
            btn_open_account = new Button("Open Account");
            btn_perform_transaction = new Button ("Perform Transaction");
            btn_display_all_accounts = new Button ("Display All Accounts");
            btn_close = new Button("Exit/Save");


            //Set button color
            btn_open_account.setStyle("-fx-background-color: Gray;");
            btn_perform_transaction.setStyle("-fx-background-color: Gray;");
            btn_display_all_accounts.setStyle("-fx-background-color: Gray;");
            btn_close.setStyle("-fx-background-color: Gray;");


            //Set font
            btn_open_account.setFont(Font.font(null, FontWeight.BOLD, 12));
            btn_perform_transaction.setFont(Font.font(null, FontWeight.BOLD, 12));
            btn_display_all_accounts.setFont(Font.font(null, FontWeight.BOLD, 12));
            btn_close.setFont(Font.font(null, FontWeight.BOLD, 12));


            //Add listeners to the buttons
            btn_open_account.setOnMouseEntered(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent e) {
                    btn_open_account.setStyle("-fx-background-color: Blue;");
                }
            });

            btn_open_account.setOnMouseExited(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent e) {
                    btn_open_account.setStyle("-fx-background-color: Gray;");
                }
            });

            btn_perform_transaction.setOnMouseEntered(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent e) {
                    btn_perform_transaction.setStyle("-fx-background-color: Blue;");
                }
            });

            btn_perform_transaction.setOnMouseExited(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent e) {
                    btn_perform_transaction.setStyle("-fx-background-color: Gray;");
                }
            });

            btn_display_all_accounts.setOnMouseEntered(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent e) {
                    btn_display_all_accounts.setStyle("-fx-background-color: Blue;");
                }
            });

            btn_display_all_accounts.setOnMouseExited(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent e) {
                    btn_display_all_accounts.setStyle("-fx-background-color: Gray;");
                }
            });


            btn_close.setOnMouseEntered(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent e) {
                    btn_close.setStyle("-fx-background-color: Blue;");
                }
            });

            btn_close.setOnMouseExited(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent e) {
                    btn_close.setStyle("-fx-background-color: Gray;");
                }
            });

            btn_open_account.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent e) {

                    //Set button color
                    btn_open_account.setStyle("-fx-background-color: #4169E1 ;");

                    pne_cards.getChildren().clear();
                    pne_cards.getChildren().add(pne_open_account);
                }
            });

            btn_perform_transaction.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent e) {

                    //Set button color
                    btn_perform_transaction.setStyle("-fx-background-color: #4169E1;");

                    pne_cards.getChildren().clear();
                    pne_cards.getChildren().add(pne_validate_account_ID);
                }
            });

            btn_display_all_accounts.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent e) {

                    //Set button color
                    btn_display_all_accounts.setStyle("-fx-background-color: #4169E1;");

                    try {
                        int account_number = 1;
                        int i =  0;
                        while (i < new_Account.length) {

                            if (i == 0) {
                                pne_output.txa_output.appendText("\n\nAll Accounts:\n");
                            }

                            if (new_Account[i] != null) {

                                pne_output.txa_output.appendText("\nAccount: " + account_number++);

                            }

                            pne_output.txa_output.appendText(new_Account[i].toString() + "\n");

                            i++;

                            if (new_Account[i] == null) {

                                pne_output.txa_output.appendText("\nTotal Accounts:\n " + i + "\n\n");

                            }
                        }

                    }catch(NullPointerException ex){

                        System.out.println("This account position is currently null.");
                    }
                }
            });

            btn_close.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent e) {

                    //Set button color
                    btn_close.setStyle("-fx-background-color: #4169E1 ;");
                    //Save files
                    writeFileIDs(Account_ID_Gen,Custumer_ID_Gen,array_postion);
                    writeFile(String.valueOf(accountsFiles),new_Account);
                    System.exit(0);

                }
            });


            //Set colour of this panel
           this.setStyle("-fx-background-color: #555555");
           this.setSpacing(5);

            //Set alignment
           this.setAlignment(Pos.CENTER);

            //Add buttons to the 'page' (pane)
           this.getChildren().addAll(imageView,btn_open_account, btn_perform_transaction, btn_display_all_accounts, btn_close);

           //Set button height
           btn_open_account.setPrefHeight(36);
           btn_perform_transaction.setPrefHeight(36);
           btn_display_all_accounts.setPrefHeight(36);
           btn_close.setPrefHeight(36);

           //Set button width
           btn_open_account.setPrefWidth(100);
           btn_perform_transaction.setPrefWidth(140);
           btn_display_all_accounts.setPrefWidth(140);
           btn_close.setPrefWidth(80);

           //Arranging all the nodes in the grid
            this.setMargin(imageView,new Insets(9,400,0,6));
            this.setMargin(btn_open_account,new Insets(20,80,0,6));
            this.setMargin(btn_open_account,new Insets(20,80,0,6));
            this.setMargin(btn_perform_transaction,new Insets(20,80,0,6));
            this.setMargin(btn_display_all_accounts,new Insets(20,80,0,6));
            this.setMargin(btn_close,new Insets(20,5,0,6));
            this.setMinSize(90, 100);

        }

    }

//  Menu pane ends


    /**
     * @param args the command line arguments<br>
     *             Created: June 16 2022<br>
     *             For: Final Project<br>
     *             Name: Number One Banking<br>
     *             Version : 1.0
     *
     *             <h1>Program Description</h1>
     *             <p>Number One Banking is a banking application that allows bank tellers to open accounts,
     *             withdraw funds, deposit funds, and check balances. It has a user-friendly interface that
     *             allows you to establish and update any number of accounts that is in the specification range.
     *             Number One Banking is the only banking application you'll ever need.</p>
     */

    public static void main(String[] args) {

//      Read file IDs
        readFileIDs(accountsFilesIDs,customerFilesIDs);

//      Read from file
        readFile(String.valueOf(accountsFiles));

//      Launch application
        launch(args);}
}
