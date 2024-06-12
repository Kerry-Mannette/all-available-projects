import java.io.Serializable;

public abstract class  Account implements Serializable {

    private String acc_num;
    public static int acc_gen = 1500 ;
    protected double balance;
    private Customer owner;
    private static int count = 0;

    /**
     * <h1>Account Method</h1>
     * <p>This method take in the account ID the balance and the owner information</p>
     * @param balance the account balance argument
     * @param owner   the account owner argument
     */

    public Account(double balance, Customer owner) {
        acc_num = "" + acc_gen;
        acc_gen += 7;
        this.balance = balance;
        this.owner = owner;
        count++;
    }

    /**
     * <h1>Get Account Number Method</h1>
     * @return acc_num the account number
     */

    public String getAcc_num() {
        return acc_num;
    }

    /**
     * <h1>Get Account Balance Method</h1>
     * @return balance the account balance
     */

    public double getBalance() {
        return balance;
    }

    /**
     * <h1>Get Account Owner Method</h1>
     * @return owner the account owner
     */

    public Customer getOwner() {
        return owner;
    }

    /**
     * <h1>Account Deposit Method</h1>
     * @param deposit_amount the account deposit argument
     */

    public void deposit(double deposit_amount) {


    }

    /**
     * <h1>Account Withdrawal Method</h1>
     * @param withdrawal_amount the withdrawal amount argument
     * @return false
     * @throws InsufficientFundsException
     */

    public boolean  withdraw(double withdrawal_amount) throws InsufficientFundsException {

        return false;
    }

    /**
     * <h1>Account Payment Method</h1>
     * @param deposit_amount the payment amount argument
     */

    public void payment(double deposit_amount) throws PartialPaymentException{



    }

    /**
     *<h1>Account To String Method</h1>
     * @return String.format the account owner
     */

    @Override
    public String toString() {
        return String.format("Account Info:\n Account Number: %s\nBalance: %.2f\nAccount Owner: %s", acc_num, balance, owner.toString());
    }

}


