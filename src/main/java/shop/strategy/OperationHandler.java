package shop.strategy;

import shop.impl.FruitTransaction;

public interface OperationHandler {
    void apply(FruitTransaction fruitTransaction);
}
