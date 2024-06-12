public final class PremiumSavings extends SavingsAccount {

    private final double int_rate;

    /**
     * <h1>Premium Saving Method</h1>
     * @param bal the balance argument
     * @param own the owner argument
     * @param ir the interest rate argument
     */

    public PremiumSavings(double bal, IndividualCustomer own, double ir) {
        super(bal, own);
        int_rate = ir;
    }

    /**
     * <h1>Get Interest Rate Method</h1>
     * @return interest rate the premium saving interest rate
     */

    public double getInt_rate() {
        return int_rate;
    }

    /**
     * <h1>Pay Interest Method</h1>
     * @param amt_entered the amount argument
     * @throws PartialPaymentException
     */

    public void payInterest(double amt_entered) throws PartialPaymentException{
        double amt_to_pay = 0;

                amt_to_pay = (amt_entered * int_rate) / 100;

    }

    /**
     * <h1>Premium Saving To String Method</h1>
     * @return String.format the premium saving information
     */

    @Override
    public String toString() {
        return String.format("Premium Savings Info:\nBalance: %s\nInterest Rate: %s",getOwner(),getBalance(),getInt_rate());
    }

}
