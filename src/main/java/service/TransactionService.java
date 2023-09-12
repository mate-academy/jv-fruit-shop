package service;

import strategy.OperationHandler;

public interface TransactionService {
    void createTransaction(String line);
    int getFruitValue();
    String getFruitName();
    OperationHandler getFruitOperationType();
}
