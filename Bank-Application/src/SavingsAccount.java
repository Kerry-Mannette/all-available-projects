public abstract class SavingsAccount extends Account{


    /**
     * <h1>Saving Account Method</h1>
     * @param bal the balance argument
     * @param own the owner argument
     */

    public SavingsAccount(double bal, IndividualCustomer own) {
        super(bal, own);
        this.balance = bal;

    }

    /**
     * <h1>Deposit Method</h1>
     * @param amount the amount argument
     */

    public void deposit(double amount){
        if (amount > 0){
            balance += amount;
            System.out.println("Deposit successful.");
        }
    }

    /**
     * <h1>Withdraw Method</h1>
     * @param amount
     * @return true
     * @throws InsufficientFundsException
     */

    public boolean withdraw( double amount) throws InsufficientFundsException{

                balance -= amount;

        return true;
    }

}
