package com.example.final_project_bank_application;

public class InsufficientFundsException extends Exception{

    /**
     * <h1>Insufficient Funds Exception Method</h1>
     */

    public InsufficientFundsException(){
        super("Your withdrawal amount exceeds your current balance.");
    }

}
