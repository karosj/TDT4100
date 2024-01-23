public class Account {
    private double balance;
    private double interestRate;

    public Account(double balance, double interestRate) {
        if (balance < 0 || interestRate < 0) {
            throw new IllegalArgumentException("Balance and interest rate must be positive");
        }
        this.balance = balance;
        this.interestRate = interestRate;
    }

    public void deposit(double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Amount must be positive");

        }
        balance += amount;

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
        if (interestRate < 0) {
            throw new IllegalArgumentException("Interest rate must be positive");
        }
        this.interestRate = interestRate;
    }

    public void withdraw(double amount) {
        if (amount < 0 || balance - amount < 0) {
            throw new IllegalArgumentException("Amount must be positive");
        }
        balance -= amount;
    }
}
