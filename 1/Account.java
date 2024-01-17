public class Account {
    private double balance;
    private double interestRate;

    public Account() {
        this.balance = 0.0;
        this.interestRate = 0.0;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public void addInterest() {
        balance += balance * (interestRate / 100.0);
    }

    public double getBalance() {
        return balance;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }
}
