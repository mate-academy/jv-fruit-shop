package core.basesyntax.strategy.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class PurchaseOperationHandlerImpl implements OperationHandler {
    @Override
    public int count(FruitTransaction fruitTransaction) {
        int quantity = fruitTransaction.getQuantity();
        checkQuantityLessThenZero(quantity);
        // IDK, how to check a balance, if I'm just summarizing quantities

        return purchase(quantity);
    }

    private int purchase(int quantity) {
        return -quantity;
    }
}
