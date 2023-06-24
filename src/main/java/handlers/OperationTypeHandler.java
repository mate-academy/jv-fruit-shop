package handlers;

import model.FruitTransaction;

public interface OperationTypeHandler {
    void handle(FruitTransaction fruitTransaction);
}
