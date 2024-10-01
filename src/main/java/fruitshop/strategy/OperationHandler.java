package fruitshop.strategy;

import fruitshop.model.FruitTransaction;

public interface OperationHandler {
    void handler(FruitTransaction fruitTransaction);
}
