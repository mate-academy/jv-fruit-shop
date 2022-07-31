package handler;

import model.FruitTransaction;

public interface OperationHandler {
    void apply(FruitTransaction fruitTransaction);
}
