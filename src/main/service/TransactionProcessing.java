package main.service;

import main.model.ProductTransaction;

import java.util.List;
import java.util.Map;

public interface TransactionProcessing {
    void perform(Map<String, List<ProductTransaction>> transactionMap);
}
