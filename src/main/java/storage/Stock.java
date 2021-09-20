package storage;

import java.util.Map;

public class Stock {
    private Map<String, Integer> stockStorage;

    public Stock(Map<String, Integer> storageReport) {
        this.stockStorage = storageReport;
    }

    public Map<String, Integer> getStockStorage() {
        return stockStorage;
    }
}
