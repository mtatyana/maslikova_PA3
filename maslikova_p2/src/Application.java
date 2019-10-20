public class Application {
    public static void main(String[] args){
        SavingsAccount saver1 = new SavingsAccount(2000.0);
        SavingsAccount saver2 = new SavingsAccount(3000.0);

        SavingsAccount.modifyInterestRate(0.04);

        for(int i = 0; i < 12; i++)
        {
            saver1.calculateMonthlyInterest();
            saver2.calculateMonthlyInterest();
        }
        System.out.println("With 4% interest, after 12 months:");
        System.out.println("Saver1: "+saver1);
        System.out.println("Saver2: "+saver2);

        SavingsAccount.modifyInterestRate(0.05);

        saver1.calculateMonthlyInterest();
        saver2.calculateMonthlyInterest();

        System.out.println("\nWith 5% interest, after a single month:");
        System.out.println("Saver1: "+saver1);
        System.out.println("Saver2: "+saver2);
    }
}
