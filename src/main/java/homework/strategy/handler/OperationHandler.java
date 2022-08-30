package homework.strategy.handler;

import homework.service.impl.FruitTransaction;

public interface OperationHandler {
    void apply(FruitTransaction fruitTransaction);

}
