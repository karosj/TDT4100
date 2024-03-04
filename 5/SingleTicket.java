public class SingleTicket implements Ticket{
    private boolean isValid;

    public SingleTicket(){
        this.isValid = true;
    }

    @Override
    public boolean scan() {
        if (isValid){
            isValid = false;
            return true;
        }
        return false;
    }
    
}
