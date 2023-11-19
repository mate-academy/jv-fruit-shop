package strategy;

import model.FruitTransaction;

public interface OperationHandler {
    int handleOperation(String fruit, int quantity);
}


