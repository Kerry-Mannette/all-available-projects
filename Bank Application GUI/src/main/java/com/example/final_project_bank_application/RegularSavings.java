package com.example.final_project_bank_application;

public final class RegularSavings extends SavingsAccount {

    /**
     * <h1>Regular Saving Method</h1>
     * @param balance the balance argument
     * @param owner the owner argument
     */

    public RegularSavings(double balance, IndividualCustomer owner) {
        super(balance, owner);
        this.balance = balance;
    }

    /**
     * <h1>Regular Saving Method</h1>
     * @return String.format the regular saving argument
     */

    @Override
    public String toString() {
        return String.format("\n %sBalance: %.2f\n",getOwner(), getBalance());
    }
}
