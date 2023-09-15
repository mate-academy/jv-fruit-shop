package service.operation;

import model.FruitTransaction;

public interface OperationHandler {
    FruitTransaction operate(FruitTransaction fruitTransaction);
}
