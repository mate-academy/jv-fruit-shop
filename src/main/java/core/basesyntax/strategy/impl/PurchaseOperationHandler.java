package core.basesyntax.strategy.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.storage.Storage;
import core.basesyntax.strategy.OperationHandler;

public class PurchaseOperationHandler implements OperationHandler {
    @Override
    public void operate(FruitTransaction fruitTransaction) {
        if (Storage.FRUITS_MAP.get(fruitTransaction.getFruit())
                - fruitTransaction.getQuantity() < 0) {
            throw new RuntimeException("We don't have enough fruits " + fruitTransaction.getFruit()
                    + ". Needed: " + fruitTransaction.getQuantity() + ", we have: "
                    + Storage.FRUITS_MAP.get(fruitTransaction.getFruit()));
        }
        Storage.FRUITS_MAP.compute(fruitTransaction.getFruit(),
                (k, v) -> v - fruitTransaction.getQuantity());
    }
}
