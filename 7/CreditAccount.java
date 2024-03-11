public class CreditAccount extends AbstractAccount{
    
    private double creditLine;

    public CreditAccount(double creditLine) {
        super();
        this.creditLine = creditLine;
    }

    public double getCreditLine() {
        return creditLine;
    }

    public void setCreditLine(double creditLine) {
        if (creditLine < 0) {
            throw new IllegalArgumentException("Credit line cannot be negative");
            
        }

        if (balance < 0 && balance <= -creditLine) {
            throw new IllegalStateException("Credit line cannot be less than the current balance");
            
        }


        this.creditLine = creditLine;
    }

    @Override
	protected void internalWithdraw(double amount) {
		if (balance - amount >= - creditLine) {
			balance -= amount;
		} else {
			throw new IllegalStateException("Not enough funds");
		}
	}
}
