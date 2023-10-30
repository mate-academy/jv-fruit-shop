package core.basesyntax.strategy.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class BalanceOperationHandlerImpl implements OperationHandler {
    @Override
    public int count(FruitTransaction fruitTransaction) {
        int quantity = fruitTransaction.getQuantity();
        checkQuantityLessThenZero(quantity);
        return quantity;
    }
}
