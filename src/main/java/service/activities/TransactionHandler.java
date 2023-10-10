package service.activities;

import model.FruitTransaction;

public interface TransactionHandler {
    void executeTransaction(FruitTransaction fruitTransaction);
}
