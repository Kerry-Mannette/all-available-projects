public final class CommercialLoan extends LoanAccount {

    private static final double ir = 0;
    private String acctManager;

    /**
     * <h1>Commercial Loan Method</h1>
     * @param bal the balance argument
     * @param own the owner argument
     * @param prin the principle argument
     * @param inst the installment argument
     * @param mgr the manager argument
     */

    public CommercialLoan(double bal, CommercialCustomer own, double prin, double inst, String mgr) {
        super(bal, own, prin, inst, ir);
        acctManager = mgr;
    }

    /**
     * <h1>Get Account Manager Method</h1>
     * @return acctManager the account manager
     */

    public String getAcctManager() {
        return acctManager;
    }

    /**
     * <h1>Commercial Loan To String Method</h1>
     * @return String.format the commercial loan information
     */
    @Override
    public String toString() {
        return String.format("Customer Info:\nBusiness Name: %s\nPrinciple: %s\nInstallment: %s\nInterest Rate: %s\nBalance: %.2f\nAccount Manager: %s",getOwner(), getPrincipal(), getInstallment(), getIntRate(), getBalance(),acctManager);
    }

}
