package core.basesyntax.strategy.impl;

import core.basesyntax.dao.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class PurchaseOperationHandler implements OperationHandler {
    private static final int DEFAULT_VALUE = 0;

    @Override
    public void operation(FruitTransaction fruitTransaction) {
        int amount = Storage.getOrDefault(fruitTransaction.getFruit(), DEFAULT_VALUE);
        int purchaseResult = amount - fruitTransaction.getQuantity();
        if (purchaseResult < 0) {
            throw new RuntimeException("Invalid Quantity value for Purchase. "
                    + "The result must not be negative");
        }
        Storage.put(fruitTransaction.getFruit(), purchaseResult);
    }
}
