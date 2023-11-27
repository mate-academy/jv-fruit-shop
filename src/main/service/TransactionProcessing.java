package main.service;

import main.model.Product;

import java.util.List;
import java.util.Map;

public interface TransactionProcessing {
    void perform(Product product);
}
