package observable;

import java.util.ArrayList;
import java.util.Collection;

public class Stock {
    private String ticker;
    private double price;
    private Collection<StockListener> listeners = new ArrayList<>();

    public Stock(String ticker, double price) {
        this.ticker = ticker;
        this.setPrice(price);
    }

    public void setPrice(double price) {
        if (price <= 0) {
            throw new IllegalArgumentException("Price must be positive.");
        }
        double oldPrice = this.price;
        this.price = price;
        notifyListeners(oldPrice, this.price);
    }

    public String getTicker() {
        return ticker;
    }

    public double getPrice() {
        return price;
    }

    public void addStockListener(StockListener listener) {
        listeners.add(listener);
    }

    public void removeStockListener(StockListener listener) {
        listeners.remove(listener);
    }

    private void notifyListeners(double oldPrice, double newPrice) {
        for (StockListener listener : listeners) {
            listener.stockPriceChanged(this, oldPrice, newPrice);
        }
    }
}