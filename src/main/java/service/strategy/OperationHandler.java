package service.strategy;

import model.FruitTransaction;

public interface OperationHandler {
    void operate(FruitTransaction transaction);
}
