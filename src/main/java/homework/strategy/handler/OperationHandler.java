package homework.strategy.handler;

import homework.model.FruitTransaction;

public interface OperationHandler {
    void apply(FruitTransaction fruitTransaction);
}
