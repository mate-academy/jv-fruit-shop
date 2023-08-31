package service.operation;

import model.FruitTransaction;

public interface OperationHandler {
    void processTransaction(FruitTransaction record);
}
