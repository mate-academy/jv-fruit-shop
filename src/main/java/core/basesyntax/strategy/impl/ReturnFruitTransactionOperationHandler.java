package core.basesyntax.strategy.impl;

import core.basesyntax.strategy.FruitTransactionOperationHandler;

public class ReturnFruitTransactionOperationHandler implements FruitTransactionOperationHandler {
    @Override
    public int handle(int quantity) {
        return quantity;
    }
}
