package service;

import model.FruitTransaction;

public interface FruitTransactionService {
    void makeOperation(FruitTransaction.Operation operation, String fruitName, int quantity);
}
