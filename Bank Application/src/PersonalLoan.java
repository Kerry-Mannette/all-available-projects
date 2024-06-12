public final class PersonalLoan extends LoanAccount {

    /**
     * <h1>Personal Loan Method</h1>
     * @param bal the balance argument
     * @param own the owner argument
     * @param prin the principal argument
     * @param inst the installment argument
     * @param ir the interest rate argument
     */

    public PersonalLoan(double bal, IndividualCustomer own, double prin, double inst, double ir) {
        super(bal, own, prin, inst, ir);
    }

    /**
     * <h1>Personal Loan To String Method</h1>
     * @return String.format the personal loan information
     */

    @Override
    public String toString() {
        return String.format("Customer Info:\nName %s\nPrinciple: %s\nInstallment: %s\nInterest Rate: %s\nBalance: %.2f",getOwner(), getPrincipal(), getInstallment(), getIntRate(), getBalance());
    }

}
