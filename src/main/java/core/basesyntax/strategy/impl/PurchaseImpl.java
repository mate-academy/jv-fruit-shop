package core.basesyntax.strategy.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.FruitHandler;

public class PurchaseImpl implements FruitHandler {
    @Override
    public void calculateFruitOperation(FruitTransaction fruitTransaction) {
        Integer storageQuantity = Storage.get(fruitTransaction.getFruit());
        if (fruitTransaction.getQuantity() <= storageQuantity
                && fruitTransaction.getQuantity() > 0) {
            Storage.put(fruitTransaction.getFruit(),
                    storageQuantity - fruitTransaction.getQuantity());
        } else {
            throw new RuntimeException("Purchase invalid count: " + fruitTransaction.getQuantity());
        }
    }
}
