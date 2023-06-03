package fruitshop.strategy.impl;

import fruitshop.model.FruitTransaction;

public class BalanceOperationStrategy implements OperationStrategy {
    @Override
    public int quantity(FruitTransaction transaction) {
        return transaction.getQuantity();
    }
}
