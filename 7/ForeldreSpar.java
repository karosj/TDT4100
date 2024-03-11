public class ForeldreSpar extends SavingsAccount{
    protected int withdrawCount;
    protected int withdrawLimit;

    public ForeldreSpar(double interest, int withdrawLimit) {
        super(interest);
        this.withdrawLimit = withdrawLimit;
    }

    public void withdraw(double amount){
        if(withdrawCount >= withdrawLimit){
            throw new IllegalStateException("You have reached the withdraw limit");
        }
        super.withdraw(amount);
        withdrawCount++;
    }

    public void endYearUpdate(){
        super.endYearUpdate();
        withdrawCount = 0;
    }

    public int getRemainingWithdrawals(){
        return withdrawLimit - withdrawCount;
    }
}
