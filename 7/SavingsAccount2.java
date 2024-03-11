public class SavingsAccount2 extends AbstractAccount {
    private int withdrawals;
    private final double fee;

    public SavingsAccount2(int withdrawals, double fee) {
        super();
        this.fee = fee;
        this.withdrawals = withdrawals;
    }

    @Override
    protected void internalWithdraw(double amount) {
        if (amount > balance) {
            throw new IllegalStateException("Not enough funds");

        }

        if (withdrawals > 0) {
            balance -= amount;
            withdrawals -= 1;
        } else if (balance >= amount + fee) {
            balance -= (amount + fee);
        } else {
            throw new IllegalStateException("No withdrawals left");
        }
    }

}
