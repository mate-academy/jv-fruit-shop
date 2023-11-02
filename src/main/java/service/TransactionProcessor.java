package service;

import model.FruitTransaction;

public interface TransactionProcessor {
    void process(FruitTransaction fruitTransaction);
}
