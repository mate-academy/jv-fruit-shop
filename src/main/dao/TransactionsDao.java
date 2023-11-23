package main.dao;

import main.model.ProductTransaction;

import java.util.List;
import java.util.Map;

public interface TransactionsDao {
    Map<String, List<ProductTransaction>> get();
}
