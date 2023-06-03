package fruitshop.strategy.handler;

import fruitshop.model.FruitTransaction;

public interface OperationHandler {
    void operate(FruitTransaction transaction);
}
