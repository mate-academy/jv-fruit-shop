package service.operation;

import model.FruitTransaction;

public interface TransactionHandler {
    void handleTransaction(FruitTransaction fruitTransaction);
}
