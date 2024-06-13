package com.example.final_project_bank_application;

import java.io.Serializable;

public class Customer implements Serializable {

    private String fname, lname, custId, address, contact;
    public static int custId_gen = 99001;

    /**
     * <h1>Customer Method</h1>
     * @param fn the first name argument
     * @param ln the last name argument
     * @param add the address name argument
     * @param con the contact name argument
     */

    public Customer(String fn, String ln, String add, String con){
        custId = ""+custId_gen++;
        fname = fn;
        lname = ln;
        address = add;
        contact = con;
    }

    /**
     * <h1>Customer Method</h1>
     * @param add the address name argument
     * @param con the contact name argument
     */

    public Customer(String add, String con) {
        custId = ""+custId_gen++;
        address = add;
        contact = con;
    }


    /**
     * <h1>Get First Name Method</h1>
     * @return fname the customer first name
     */

    public String getFname() {return fname;}

    /**
     * <h1>Het First Name Method</h1>
     * @return lname the  customer last name
     */

    public String getLname() {return lname;}

    /**
     * <h1>Get Customer ID Method</h1>
     * @return cusId the customer ID
     */

    public String getCustId() { return custId; }

    /**
     * <h1>Get Customer Address</h1>
     * @return address the customer address
     */

    public String getAddress() {
        return address;
    }

    /**
     * <h1>Get Contact Method</h1>
     * @return contact the customer contact
     */

    public String getContact() {
        return contact;
    }

    /**
     * <h1>Customer Summary Method</h1>
     * @return String.format the customer summary
     */

    public String customerSummary() {
        return String.format("Customer Info:\nName: %s %s\nAddress: %s\nPhone contact: %s",fname, lname, address, contact);
    }

    /**
     * <h1>Customer To String Method</h1>
     * @return String.format the customer information
     */

    @Override
    public String toString() {
        return String.format("Customer Info:\nCustomer ID: %s\nCustomer Name: %s %s\nAddress: %s\nPhone contact: %s\n",custId, fname, lname, address, contact);
    }

}
