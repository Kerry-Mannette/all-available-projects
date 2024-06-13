module com.example.final_project_bank_application {
    requires javafx.controls;
    requires javafx.fxml;
            
                        
    opens com.example.final_project_bank_application to javafx.fxml;
    exports com.example.final_project_bank_application;
}