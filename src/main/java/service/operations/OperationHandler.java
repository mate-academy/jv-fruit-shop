package service.operations;

import model.FruitTransaction;

public interface OperationHandler {
    void operate(FruitTransaction transaction);
}
