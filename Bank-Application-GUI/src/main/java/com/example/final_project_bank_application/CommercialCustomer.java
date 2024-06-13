package com.example.final_project_bank_application;

public class CommercialCustomer extends Customer{

    private String birRegistrationId, business_name;
    private char id_type;

    /**
     * <h1>Commercial Customer Method </h1>
     * @param add the address argument
     * @param con the contact argument
     * @param regID the registration ID name argument
     * @param type the ID type argument
     */

    public CommercialCustomer(String add, String con, String regID, String dir, char type){

        super( add, con);

        birRegistrationId = regID;
        business_name = dir;
        id_type = type;
    }

    /**
     * <h1>Get Registration ID Method</h1>
     * @return birRegistrationId the commercial customer registration ID
     */

    public String getRegistrationId() {

        return birRegistrationId;

    }

    public String getBusinessName() {
        return business_name;
    }

    /**
     * <h1>Get ID Type Method</h1>
     * @return id_type the commercial customer ID type
     */

    public char getIdType() {
        return id_type;
    }

    /**
     * <h1>Customer Summary Method</h1>
     * @return super.customerSummary the commercial customer summary
     */

    @Override
    public String customerSummary() {
        return super.customerSummary();
    }


    /**
     * <h1>Commercial Customer To String Method</h1>
     * @return String.format the commercial customer owner  information
     */

    @Override
    public String toString() {
        return String.format("\nCustomer Info:\nBusiness Name: %s\nAddress: %S\nContact: %S\nRegistration ID: %s\nRegistration Type: %s", business_name,getAddress(),getContact(), birRegistrationId, id_type);
    }

}
