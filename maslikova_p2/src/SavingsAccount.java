public class SavingsAccount {
    private static double annualInterestRate;
    private double savingsBalance;

    public SavingsAccount(double initialBalance){
        this.savingsBalance = initialBalance;
    }

    public void calculateMonthlyInterest() {
        this.savingsBalance *= 1 + annualInterestRate / 12.0;
    }

    public static void modifyInterestRate(double newRate) {
        annualInterestRate = newRate;
    }

    public String toString(){
        return "Savings Account, Current Balance: "+String.format("$%.2f", this.savingsBalance);
    }
}
