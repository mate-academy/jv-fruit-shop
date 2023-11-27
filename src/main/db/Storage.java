package main.db;

import main.model.Product;

import java.util.HashMap;
import java.util.Map;

public class Storage {
    private Map<String, Integer> reportData = new HashMap<>();

    public void addToReportData(Product product) {
        reportData.put(product.getProductName(), product.getQuantity());
    }

    public Map<String, Integer> getReportData() {
        return reportData;
    }
}
