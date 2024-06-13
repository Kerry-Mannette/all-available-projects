package com.example.final_project_bank_application;

public class IndividualCustomer extends Customer{

    private String  identification;
    private char id_type;

    /**
     *
     * @param fn the first name argument
     * @param ln the last name argument
     * @param add the address argument
     * @param con the contact argument
     * @param id the identification argument
     * @param type the ID type argument
     */

    public IndividualCustomer(String fn, String ln, String add, String con, String id, char type){
        super(fn, ln, add, con);
        identification = id;
        id_type = type;
    }

    /**
     * <h1>Get Identification Method</h1>
     * @return identification the individual customer identification
     */

    public String getIdentification() {
        return identification;
    }

    /**
     * <h1>Get ID Type Method</h1>
     * @return id_type the individual customer ID type
     */

    public char getIdType() {
        return id_type;
    }

    /**
     * <h1>Customer Summary Method</h1>
     * @return super.customerSummary the individual customer summary
     */

    @Override
    public String customerSummary() {
        return super.customerSummary();
    }

    /**
     * <h1>Individual Customer To String Method</h1>
     * @return String.format the individual customer information
     */

    @Override
    public String toString(){
        return String.format("\nCustomer Info:\nCustomer name: %s %s\nCustomer ID: %s\nID Type: %s\nAddress: %s\nPhone contact: %s\n",getFname(), getLname(), identification, id_type, getAddress(), getContact());
    }

}
