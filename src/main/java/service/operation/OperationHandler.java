package service.operation;

import models.FruitTransaction;

public interface OperationHandler {
    void handle(FruitTransaction fruitTransaction);
}
