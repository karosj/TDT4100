public class BSU extends SavingsAccount{

    protected double maxDeposit;
    protected double availableBalance;

    public BSU(double interest, double maxDeposit) {
        super(interest);
        availableBalance = 0;
        this.maxDeposit = maxDeposit;
    }

    public void deposit(double amount){
        if(availableBalance + amount > maxDeposit){
            throw new IllegalStateException("Deposit exceeds maximum deposit");
        }
        else{
            availableBalance += amount;
            super.deposit(amount);
        }
    }

    public void withdraw(double amount){
        if(amount > availableBalance){
            throw new IllegalStateException("Withdraw exceeds available balance");
        }
        else{
            availableBalance -= amount;
            super.withdraw(amount);
        }
    }

    public void endYearUpdate(){
        super.endYearUpdate();
        availableBalance = 0;
    }

    public double getTaxDeduction(){
        return availableBalance * 0.2;
    }


}
