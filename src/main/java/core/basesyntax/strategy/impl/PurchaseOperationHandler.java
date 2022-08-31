package core.basesyntax.strategy.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.storage.Storage;
import core.basesyntax.strategy.OperationHandler;

public class PurchaseOperationHandler implements OperationHandler {
    @Override
    public void apply(FruitTransaction transaction) {
        Integer currentQuantity = Storage.storage.get(transaction.getFruit());
        if (currentQuantity >= transaction.getCount()) {
            Storage.storage.put(transaction.getFruit(), currentQuantity - transaction.getCount());
        } else {
            throw new RuntimeException("Unfortunately, we only have " + currentQuantity
                    + Storage.storage.get(transaction.getFruit().getName()));
        }
    }
}
