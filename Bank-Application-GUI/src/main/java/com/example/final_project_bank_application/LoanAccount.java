package com.example.final_project_bank_application;

public abstract class LoanAccount extends Account{
    
    private final double principal;
    private double installment;
    private double int_rate;

    /**
     *
     * @param bal the balance argument
     * @param own the owner argument
     * @param prin the principal argument
     * @param inst the installment argument
     * @param ir the interest rate argument
     */

    public LoanAccount(double bal, Customer own, double prin, double inst, double ir) {
        super(bal, own);
        balance = bal;
        principal = prin;
        installment = inst;
        int_rate = ir;
    }

    /**
     * <h1>Get Principal Method</h1>
     * @return principal the loan account principal
     */

    public double getPrincipal() {
        return principal;
    }

    /**
     * <h1>Get Installment Method</h1>
     * @return installment the loan account installment
     */

    public double getInstallment() {
        return installment;
    }

    /**
     * <h1>Get Interest Rate Method</h1>
     * @return int_rate the loan account interest rate
     */

    public double getIntRate() {
        return int_rate;
    }

    /**
     * <h1>Payment Method</h1>
     * @param amt_entered the payment amount argument
     */

    public void payment( double amt_entered) throws PartialPaymentException {
        double amt_to_pay;

        amt_to_pay = amt_entered - (amt_entered*int_rate);
        balance -= amt_to_pay;

               if (amt_entered < installment){

                   throw new PartialPaymentException();

               }

            }


    }

