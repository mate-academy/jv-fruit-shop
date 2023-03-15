package core.basesyntax.strategy.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class PurchaseOperationHandler implements OperationHandler {
    @Override
    public void doActivity(FruitTransaction fruitTransaction) {
        int amount = Storage.getOrDefault(fruitTransaction.getFruit(), DEFAULT_VALUE);
        int resultQuantity = amount - fruitTransaction.getQuantity();
        if (resultQuantity < 0) {
            throw new RuntimeException("Purchase amount is: " + amount
            + ", current quantity is: " + Storage.get(fruitTransaction.getFruit()));
        }
        Storage.put(fruitTransaction.getFruit(), resultQuantity);
    }
}
