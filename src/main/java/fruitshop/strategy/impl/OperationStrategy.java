package fruitshop.strategy.impl;

import fruitshop.model.FruitTransaction;

public interface OperationStrategy {
    int quantity(FruitTransaction transaction);
}
