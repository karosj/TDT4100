package observable;

import java.util.ArrayList;
import java.util.List;

public class StockIndex implements StockListener {
    private String name;
    private double index = 0;
    private List<Stock> stocks = new ArrayList<>();

    public StockIndex(String name, Stock... stocks) {
        this.name = name;
        for (Stock stock : stocks) {
            addStock(stock);
        }
    }

    public void addStock(Stock stock) {
        if (!stocks.contains(stock)) {
            stocks.add(stock);
            index += stock.getPrice();
            stock.addStockListener(this);
        }
    }

    public void removeStock(Stock stock) {
        if (stocks.contains(stock)) {
            stocks.remove(stock);
            index -= stock.getPrice();
            stock.removeStockListener(this);
        }
    }

    public double getIndex() {
        return index;
    }

    @Override
    public void stockPriceChanged(Stock stock, double oldValue, double newValue) {
        index += (newValue - oldValue);
    }
}
