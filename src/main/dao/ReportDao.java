package main.dao;

import main.model.Product;

import java.util.Map;

public interface ReportDao {
    Map<String, Integer> get();
    void update(Product product);

    int getBalanceForProduct(Product product);
}
