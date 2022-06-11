package service;

import model.FruitTransaction;

public interface OperationStrategy {
    OperationService getOperationServiceByTransaction(FruitTransaction transaction);
}
