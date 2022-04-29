package strategy;

import model.FruitTransaction;

public interface OperationHandler {
    void process(FruitTransaction fruitTransaction);
}
