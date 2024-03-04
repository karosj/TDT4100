import java.util.Iterator;

public class CardContainerIterator implements Iterator<Card> {
    private CardContainer container;
    private int index = 0;

    public CardContainerIterator(CardContainer container){
        this.container = container;
    }

    @Override
    public boolean hasNext() {
        return index < container.getCardCount();
       
    }

    @Override
    public Card next() {
        return container.getCard(index++);
    }
    
}
