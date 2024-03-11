public class SavingsAccount implements Account{
    private double balance;
    private double interest;

    public SavingsAccount(double interest) {
        this.balance = 0;
        this.interest = interest;
    }

    @Override
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        } else {
            throw new IllegalArgumentException("Amount must be greater than 0");
        }
    }

    @Override
    public void withdraw(double amount) {
       if (amount < 0) {
              throw new IllegalArgumentException("Amount must be greater than 0");
         } else if (balance - amount < 0) {
              throw new IllegalStateException("Insufficient funds");
         } else {
              balance -= amount;
       }
    }

    @Override
    public double getBalance() {
        return balance;
    }

    public void endYearUpdate() {
        balance *= (1 + interest);
    }


}
