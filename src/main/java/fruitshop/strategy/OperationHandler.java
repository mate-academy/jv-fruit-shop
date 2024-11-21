package fruitshop.strategy;

import fruitshop.model.FruitTransaction;

public interface OperationHandler {
    void apply(FruitTransaction transaction);
}
