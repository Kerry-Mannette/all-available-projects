import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
public class Bank {

    public static String Letter;
    public static int i;
    public static Scanner input = new Scanner(System.in);
    public static File accountsFiles = new File("Accounts Information's/Accounts Information's.txt");
    public static ArrayList<Account> new_Account = new ArrayList<Account>();
    public static String F_name, L_name, Address, Contact, Identification_number;
    public static char Identification_type;
    public static double Starting_Balance, Interest_Rate, Principle, Installment;
    public static String Business_registration_Number, Business_Name, Manager_Name;
    public static String Validate_Account_ID;
    public static double Withdrawal_Amount, Deposit_Amount, Payment_Amount;


    /**
     * @param args the command line arguments<br>
     *             Created: May 16 2022<br>
     *             For: Assignment Two<br>
     *             Name: Number One Banking<br>
     *             Version : 1.0
     *
     *             <h1>Program Description</h1>
     *             <p>Number One Banking is a banking application that allows bank tellers to open accounts,
     *             withdraw funds, deposit funds, and check balances. It has a user-friendly interface that
     *             allows you to establish and update any number of accounts. Number One Banking is the only banking
     *             application you'll ever need.</p>
     */


    public static void main(String[] args) {

        /**
         * <p>Declare all variables the use of (Data type: String)</p>
         */

        String Welcome_Greeting = "Welcome to Number One Banking (Version: 1.0)";


        System.out.println(Welcome_Greeting + "\n");

        readFile(String.valueOf(accountsFiles),new_Account);

        Bank_Application_Main_Menu();

}


//  Bank application main menu

    /**
     * <h1>Bank Application Main Menu Method</h1>
     * <p>Use to select between creating an account, selecting and account or exiting the application.</p>
     */

    public static void Bank_Application_Main_Menu(){

        /**
         * <p>Declare all variables the use of (All variables are declared outside of method)</p>
         */


        System.out.println(" Please select:\tO - To open an account."
                + "\n Please select:\tS - To select an account."
                + "\n Please select:\tE - To exit.");
        Letter = input.next().toUpperCase();
        Account_Menu_Selection(Letter);

    }

 // Bank application main menu end


// Write to file

    /**
     * <h1>Write To File Method</h1>
     * <p>Use to create new account or update information.</p>
     * @param fileName the file name argument
     * @param data the data argument
     */

    public static void writeFile (String fileName, ArrayList <Account> data){

       /**
        * <p>Declare all variables the use of (All variables are declared outside of method)</p>
        */

       try {
           FileOutputStream FO = new FileOutputStream(fileName,true);
           ObjectOutputStream output = new ObjectOutputStream(FO);

               output.writeObject(data);

           FO.close();
           output.close();

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
     * @param data the data argument //check
     */

    public static void readFile(String fileName, ArrayList<Account> data){

        /**
         * <p>Declare all variables the use of (All variables are declared outside of method)</p>
         */

        try(ObjectInputStream readStream = new ObjectInputStream(new FileInputStream(fileName))){

            while(true){

                new_Account = (ArrayList<Account>) readStream.readObject();

            }

        } catch(ClassNotFoundException e){
            System.out.println(e.getMessage());
        } catch (FileNotFoundException e){
            System.out.println("Error! Cannot find file: "+fileName);
        } catch (IOException e){ if (e instanceof EOFException)
           System.out.println("Fail to load file: "+fileName+"\n"+"File may be empty or corrupted.\n ");
        }

    }

//  Read file end


// Account menu selection

    /**
     * <h1>Account Menu Selection Method</h1>
     * <p>This method is used to determine the operation the user want to do.</p>
     * @param Letter the menu selection argument
     */

    public static void Account_Menu_Selection(String Letter){

        /**
         * <p>Declare all variables the use of (Data type: String, int)</p>
         */

        int Menu_Selection, Sub_Menu_Selection;

        /**
              Get user selection for: (Saving account or Loan account)
                                                                         **/


        if(Letter.equalsIgnoreCase("O")){

            System.out.println("Please select:\n1 for Savings Account.\n2 for Loan Account.");
            Menu_Selection = input.nextInt();

            if(Menu_Selection == 1){

                System.out.println("Please select:\n1 for Regular Savings Account.\n2 for Premium Saving Account.");
                Sub_Menu_Selection = input.nextInt();

                if(Sub_Menu_Selection == 1){
                    Regular_Savings_Account();
                }else if(Sub_Menu_Selection == 2){
                    Premium_Savings_Account();
                }else {
                    System.out.println("Invalid Selection");
                }



            /**
                  Get user selection for: (Personal Loan or Commercial Loan)
                                                                               **/


            }else if(Menu_Selection == 2){

                System.out.println("Please select:\n1 for Personal Loan.\n2 for Commercial Loan.");
                Sub_Menu_Selection = input.nextInt();

                if(Sub_Menu_Selection == 1){
                    Personal_Loan_Account();
                }else if(Sub_Menu_Selection == 2){
                    Commercial_Loan_Account();
                }else {
                    System.out.println("Invalid Selection");
                }

            }else{
                System.out.println("Invalid Selection");
            }

        }else if (Letter.equalsIgnoreCase("S")){

            Validate_Account_ID();

        }else if(Letter.equalsIgnoreCase("E")){
            System.out.println("Please Wait. Information is being saved. \n ");
            writeFile(String.valueOf(accountsFiles),new_Account);
            System.out.println("Information was saved successfully. \n ");
            System.out.println("Thanks for your service. Goodbye!");
            System.exit(0);
            return;
        }

    }

// Account menu selection end


//  All regular savings account

    /**
     * <h1>Regular Saving Account Method</h1>
     * <p>Use to create a regular saving account.</p>
     */

    public static void Regular_Savings_Account(){

        /**
         * <p>Declare all variables the use of (All variables are declared outside of method)</p>
         */

        do{

        System.out.println("\nNote: To open an account you must provide a first name, last name, address, contact, identification, and ID type.");

//      Get customer name
        System.out.println("\n\nPlease enter the First and Last name (e.g. John Doe): ");
        F_name = input.next();
        L_name = input.next();
        input.nextLine();

//      Get customer address
        System.out.println("Please enter the address (e.g. #123-Henry-ST-Port-of-Spain): ");
        Address = input.next();
        input.nextLine();

//      Get customer contact
        System.out.println("Please enter the contact information (e.g. 1868-333-3333): ");
        Contact = input.next();
        input.nextLine();

//      Get starting balance
        try {
            System.out.println("Please enter the starting balance on the account (e.g. 100.00): ");
            Starting_Balance = input.nextDouble();
            while (Starting_Balance < 100) {
                System.out.println("Invalid! Please enter a starting balance of no less than 100.00." +
                        "\n\nPlease enter the starting balance on the account (e.g. 100.00): ");
                Starting_Balance = input.nextDouble();
            }
        } catch (InputMismatchException ex) {
            System.out.println("Invalid! Please enter an integer value."
                    + "\nThe account starting balance is: $0.00"
                    + "\nPlease reenter the information for the account.");
            break;
        }

//      Get identification number
        System.out.println("Please enter the identification number (e.g. 2888888888): ");
        Identification_number = input.next();
        input.nextLine();

//      Get identification type
        System.out.println("Please enter the identification type (e.g. N for : National ID, D for : Drivers License, or B for : Birth Certificate): ");
        Identification_type = input.next().toUpperCase().charAt(0);


                new_Account.add(i, new RegularSavings(Starting_Balance, new IndividualCustomer(F_name, L_name, Address, Contact, Identification_number, Identification_type)));
                i++;

//      Print account ID
            System.out.println("The account was created successfully. \n Make sure to save the account ID in a safe place. \n Here is the account ID: " + new_Account.get(i).getAcc_num());
            System.out.println();
            Bank_Application_Main_Menu();

        } while(true);


    }


// Premium savings account

    /**
     * <h1>Premium Saving Account Method</h1>
     * <p>Use to create a premium saving account.</p>
     */

    public static void Premium_Savings_Account(){

        /**
         * <p>Declare all variables the use of (All variables are declared outside of method)</p>
         */

        do{

        System.out.println("\nNote: To open an account you must provide a first name, last name, address, contact, identification, and ID type .");

//      Get customer name
        System.out.println("\n\nPlease enter the First and Last name (e.g. John Doe): ");
        F_name = input.next();
        L_name = input.next();
        input.nextLine();

//      Get customer addresses
        System.out.println("Please enter the address (e.g. #123-Henry-ST-Port-of-Spain): ");
        Address = input.next();
        input.nextLine();

//      Get customer contact
        System.out.println("Please enter the contact information (e.g. 1868-333-3333): ");
        Contact = input.next();
        input.nextLine();

//      Get starting balance
        try {
            System.out.println("Please enter the starting balance on the account (e.g. 100.00): ");
            Starting_Balance = input.nextDouble();
            while (Starting_Balance < 100) {
                System.out.println("Invalid! Please enter a starting balance of no less than 100.00." +
                        "\n\nPlease enter the starting balance on the account (e.g. 100.00): ");
                Starting_Balance = input.nextDouble();
            }
        } catch (InputMismatchException ex) {
            System.out.println("Invalid! Please enter an integer value."
                    + "\nThe account starting balance is: $0.00"
                    + "\nPlease reenter the information for the account.");
            break;
        }

//      Get customer identification number
            System.out.println("Please enter the identification number (e.g. 2888888888): ");
            Identification_number = input.next();
            input.nextLine();

//      Get identification type
            System.out.println("Please enter the identification type (e.g. N for : National ID, D for : Drivers License, or B for : Birth Certificate): ");
            Identification_type = input.next().toUpperCase().charAt(0);

//      Get interest rate
            try {

                System.out.println("Please enter the interest rate (e.g. .06 = 6% ): ");
                Interest_Rate = input.nextDouble();

                while (Interest_Rate < .01) {
                    System.out.println("Invalid! Please enter a interest rate no less than .06 = 6% ." +
                            "\n\nPlease enter the interest rate on the account (e.g. .06 = 6%): ");
                    Interest_Rate = input.nextDouble();
                }
            } catch (InputMismatchException ex) {
                System.out.println("Invalid! Please enter an integer value."
                        + "\nThe account interest rate is: $0.00"
                        + "\nPlease reenter the information for the account.");
                break;
            }


            new_Account.add(i, new PremiumSavings(Starting_Balance, new IndividualCustomer(F_name, L_name, Address, Contact, Identification_number, Identification_type), Interest_Rate));
            i++;

//          Print account ID
            System.out.println("The account was created successfully. \n Make sure to save the account ID in a safe place. \n Here is the account ID: " + new_Account.get(i).getAcc_num());
            System.out.println();
            Bank_Application_Main_Menu();

        } while(true);

    }

//  End of premium saving account



//  Personal loan account

    /**
     * <h1>Personal Loan Account Method</h1>
     * <p>Use to create a personal loan account</p>
     */

    public  static void Personal_Loan_Account(){

        /**
         * <p>Declare all variables the use of (All variables are declared outside of method)</p>
         */

        do{

        System.out.println("\nNote: To apply for a loan you must provide a first name, last name, address, contact, identification, and ID type .");

//      Get customer name
        System.out.println("\n\nPlease enter the First and Last name (e.g. John Doe): ");
        F_name = input.next();
        L_name = input.next();
        input.nextLine();

//      Get customer address
        System.out.println("Please enter the address (e.g. #123-Henry-ST-Port-of-Spain): ");
        Address = input.next();
        input.nextLine();

//      Get customer contact
        System.out.println("Please enter the contact information (e.g. 1868-333-3333): ");
        Contact = input.next();
        input.nextLine();


//      Get starting balance
        try {
            System.out.println("Please enter the starting balance on the account (e.g. 2000.00): ");
            Starting_Balance = input.nextDouble();
            while (Starting_Balance < 2000) {
                System.out.println("Invalid! Please enter a starting balance of no less than 2000.00." +
                        "\n\nPlease enter the starting balance on the account (e.g. 2000.00): ");
                Starting_Balance = input.nextDouble();
            }
        } catch (InputMismatchException ex) {
            System.out.println("Invalid! Please enter an integer value."
                    + "\nThe account starting balance is: $0.00"
                    + "\nPlease reenter the information for the account.");
            break;
        }

//      Get identification number
        System.out.println("Please enter the identification number (e.g. 2888888888): ");
        Identification_number = input.next();
        input.nextLine();

//      Get identification type
        System.out.println("Please enter the identification type (e.g. N for : National ID, D for : Drivers License, or B for : Birth Certificate): ");
        Identification_type = input.next().toUpperCase().charAt(0);


//      Get interest rate
            try {

                System.out.println("Please enter the interest rate (e.g. .08 = 8% ): ");
                Interest_Rate = input.nextDouble();

                while (Interest_Rate < .01) {
                    System.out.println("Invalid! Please enter a interest rate no less than .08 = 8% ." +
                            "\n\nPlease enter the interest rate on the account (e.g. .08 = 8%): ");
                    Interest_Rate = input.nextDouble();
                }
            } catch (InputMismatchException ex) {
                System.out.println("Invalid! Please enter an integer value."
                        + "\nThe account interest rate is: $0.00"
                        + "\nPlease reenter the information for the account.");
                break;
            }


//          Get principle
            try {

            System.out.println("Please enter the principle (e.g. 250.00): ");
            Principle = input.nextDouble();

            while (Principle < 250) {
                System.out.println("Invalid! Please enter a principle no less than 250.00." +
                        "\n\nPlease enter the interest rate on the account (e.g. 250.00): ");
                Principle = input.nextDouble();
            }
        } catch (InputMismatchException ex) {
            System.out.println("Invalid! Please enter an integer value."
                    + "\nThe account principle is: $0.00"
                    + "\nPlease reenter the information for the account.");
            break;
        }


//      Get installment
        try {

            System.out.println("Please enter the installment (e.g. 2000.00): ");
            Installment = input.nextDouble();

            while (Installment < 2000) {
                System.out.println("Invalid! Please enter a in no less than 2000.00." +
                        "\n\nPlease enter the interest rate on the account (e.g. 2000.00): ");
                Installment = input.nextDouble();
            }

        } catch (InputMismatchException ex) {
            System.out.println("Invalid! Please enter an integer value."
                    + "\nThe account installment is: $0.00"
                    + "\nPlease reenter the information for the account.");
            break;
        }


           new_Account.add(i, new PersonalLoan(Starting_Balance, new IndividualCustomer(F_name, L_name, Address, Contact, Identification_number, Identification_type), Principle, Installment, Interest_Rate));
           i++;

//          Get account ID
            System.out.println("The account was created successfully. \n Make sure to save the account ID in a safe place. \n Here is the account ID: " + new_Account.get(i).getAcc_num());
            System.out.println();
            Bank_Application_Main_Menu();

        } while(true);

    }

 // End of personal loan account


// Commercial loan account

    /**
     * <h1>Commercial Loan Account Method</h1>
     * <p>Use to create a commercial loan account</p>
     */

    public static void Commercial_Loan_Account() {

        /**
         * <p>Declare all variables the use of (All variables are declared outside of method)</p>
         */

        do{

        System.out.println("\nNote: To apply for a loan you must provide a business name, address, contact, registration ID.");

//      Get customer name
        System.out.println("\n\nPlease enter the business name (e.g. Number One Banking): ");
        Business_Name = input.next();
        input.nextLine();

//      Get customer address
        System.out.println("Please enter the address (e.g. #123-Henry-ST-Port-of-Spain): ");
        Address = input.next();
        input.nextLine();

//      Get customer contact
        System.out.println("Please enter the contact information (e.g. 1868-333-3333): ");
        Contact = input.next();
        input.nextLine();

//      Get business registration
        System.out.println("Please enter the business registration number (e.g. 3111100111): ");
        Business_registration_Number = input.next();
        input.nextLine();

        //     Get identification type
        System.out.println("Please enter the identification type (e.g. S for : Sole Trader, P for : Partnership, or L for : Limited Liability): ");
        Identification_type = input.next().toUpperCase().charAt(0);

//      Get starting balance
        try {
            System.out.println("Please enter the starting balance on the account (e.g. 10000.00): ");
            Starting_Balance = input.nextDouble();
            while (Starting_Balance < 10000) {
                System.out.println("Invalid! Please enter a starting balance of no less than 10000.00." +
                        "\n\nPlease enter the starting balance on the account (e.g. 10000.00): ");
                Starting_Balance = input.nextDouble();
            }
        } catch (InputMismatchException ex) {
            System.out.println("Invalid! Please enter an integer value."
                    + "\nThe account starting balance is: $0.00"
                    + "\nPlease reenter the information for the account.");
        }


//      Get interest rate
        try {

            System.out.println("Please enter the interest rate (e.g. .025 = 25% ): ");
            Interest_Rate = input.nextDouble();

            while (Interest_Rate < .01) {
                System.out.println("Invalid! Please enter a interest rate no less than .025 = 25% ." +
                        "\n\nPlease enter the interest rate on the account (e.g. .025 = 25%): ");
                Interest_Rate = input.nextDouble();
            }
        } catch (InputMismatchException ex) {
            System.out.println("Invalid! Please enter an integer value."
                    + "\nThe account interest rate is: $0.00"
                    + "\nPlease reenter the information for the account.");
        }


//     Get principle
        try {

            System.out.println("Please enter the principle (e.g. 10000.00): ");
            Principle = input.nextDouble();

            while (Principle < 10000) {
                System.out.println("Invalid! Please enter a principle no less than 1000.00." +
                        "\n\nPlease enter the interest rate on the account (e.g. 10000.00): ");
                Principle = input.nextDouble();
            }
        } catch (InputMismatchException ex) {
            System.out.println("Invalid! Please enter an integer value."
                    + "\nThe account principle is: $0.00"
                    + "\nPlease reenter the information for the account.");
        }


//      Get installment
        try {

            System.out.println("Please enter the installment (e.g. 12000.00): ");
            Installment = input.nextDouble();

            while (Installment < 12000) {
                System.out.println("Invalid! Please enter a in no less than 12000.00." +
                        "\n\nPlease enter the interest rate on the account (e.g. 12000.00): ");
                Installment = input.nextDouble();
            }
        } catch (InputMismatchException ex) {
            System.out.println("Invalid! Please enter an integer value."
                    + "\nThe account installment is: $0.00"
                    + "\nPlease reenter the information for the account.");
        }


//      Get manager name
        System.out.println("Please enter the account manager name (e.g. John Doe): ");
        Manager_Name = input.next();


        new_Account.add(i, new CommercialLoan(Starting_Balance, new CommercialCustomer(Address, Contact, Business_registration_Number,Business_Name, Identification_type), Installment, Interest_Rate, Manager_Name));
        i++;

//      Get account ID
        System.out.println("The account was created successfully. \n Make sure to save the account ID in a safe place. \n Here is the account ID: " + new_Account.get(i).getAcc_num());
        System.out.println();
        input.nextLine();
       break;
    }while(true);

        Bank_Application_Main_Menu();

    }

 //  End of commercial loan account


 // Validate account ID

    /**
     *<h1>Validate Account ID Method</h1>
     * <p>Use to validate an account ID</p>
     */

    public static void Validate_Account_ID(){

        /**
         * <p>Declare all variables the use of (Data type: int)</p>
         */

        int account_position = -1;

        do{

        System.out.println("Please enter the account ID: ");
        Validate_Account_ID = input.next();

        for (int i = 0; i <new_Account.size(); i++){
            if (new_Account.get(i) != null) {
                if (Validate_Account_ID.equals(new_Account.get(i).getAcc_num())){
                    account_position = i;
                    break;
                }
            }
        }if (account_position != -1){
            System.out.println("This account belongs to: \n " + new_Account.get(account_position).getOwner());
            Select_An_Account_Transaction(account_position,new_Account);
            break;
        }else{
            System.out.println("Invalid! Account does not exist.");
        }

       }while(true);

}

// End of validate account ID


//   Account transaction

    /**
     * <h1>Select An Account Transaction</h1>
     * <p>Use to select the type of transaction the user wants to do.</p>
     * @param account_position the account position argument
     * @param new_Account the read account argument
     */

    public static void Select_An_Account_Transaction(int account_position, ArrayList<Account> new_Account){

        /**
         * <p>Declare all variables the use of (Data type: String)</p>
         */

        String Account_Selection;
        String Menu_Letters [] = {"D", "I", "Q","P"};


        do {

            System.out.println("\nPlease select:\tW - For withdrawal."
                    + "\nPlease select:\tD - To deposit."
                    + "\nPlease select:\tP - To make a payment."
                    + "\nPlease select:\tI - For balance inquiry."
                    + "\nPlease select:\tQ - To quit/exit.");
            Account_Selection = input.next().toUpperCase();

            try{

                switch (Account_Selection) {
                    case "W":
                        System.out.println("Please enter the withdrawal amount: ");
                        Withdrawal_Amount = input.nextDouble();
                        if (new_Account.get(account_position).getBalance() < Withdrawal_Amount){
                            throw new InsufficientFundsException();
                        }else{
                            new_Account.get(account_position).withdraw(Withdrawal_Amount);
                        }
                        break;

                    case "D":
                        System.out.println("Please enter the deposit amount: ");
                        Deposit_Amount = input.nextDouble();
                        new_Account.get(account_position).deposit(Deposit_Amount);
                        while (Deposit_Amount < 1) {
                            System.out.println("Please enter a deposit amount that is greater than zero."
                                    + "\n\nPlease enter the deposit amount: ");
                            Deposit_Amount = input.nextDouble();
                            new_Account.get(account_position).deposit(Deposit_Amount);
                        }
                        break;

                    case "P":
                        System.out.println("Please enter the payment amount: ");
                        Payment_Amount = input.nextDouble();
                        if (Payment_Amount < Installment) {
                            throw new PartialPaymentException();
                        }else {
                            new_Account.get(account_position).payment(Deposit_Amount);
                        }
                        break;

                    case "I":
                        System.out.println(new_Account.get(account_position).toString());
                        break;

                    case "Q":
                           Bank_Application_Main_Menu();
                        break;

                    default: if(!Account_Selection.equalsIgnoreCase(String.valueOf(Menu_Letters)))System.out.println("Invalid!");

                }
            } catch (InputMismatchException ex) {
                System.out.println("Invalid! Please enter an integer value.");
                input.next();
            } catch (InsufficientFundsException e) {
               System.out.println(e.getMessage());
            } catch (PartialPaymentException e) {
                System.out.println(e.getMessage());
            }
        }while (true);

    }

 //  End of account transaction


}
