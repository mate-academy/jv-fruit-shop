package service;

import model.FruitTransaction;

public interface OperationHandler {
    void doTransaction(FruitTransaction transaction);
}
