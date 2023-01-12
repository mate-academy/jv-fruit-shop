package core.basesyntax.strategy.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.storage.Storage;
import core.basesyntax.strategy.OperationHandler;

public class PurchaseOperationHandler implements OperationHandler {
    @Override
    public void operate(FruitTransaction fruitTransaction) {
        if (Storage.fruits.get(fruitTransaction.getFruit()) - fruitTransaction.getQuantity() < 0) {
            throw new RuntimeException("We don't have enough fruits " + fruitTransaction.getFruit()
                    + ". Needed: " + fruitTransaction.getQuantity() + ", we have: "
                    + Storage.fruits.get(fruitTransaction.getFruit()));
        }
        Storage.fruits.compute(fruitTransaction.getFruit(),
                (k, v) -> v - fruitTransaction.getQuantity());
    }
}
