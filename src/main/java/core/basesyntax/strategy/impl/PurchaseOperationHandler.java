package core.basesyntax.strategy.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class PurchaseOperationHandler implements OperationHandler {
    @Override
    public void apply(FruitTransaction transaction) {
        Fruit fruit = transaction.getFruit();
        Integer currentQuantity = Storage.storageMap.get(fruit);
        if (currentQuantity == null) {
            throw new RuntimeException("Field value " + fruit + " can't be null");
        } else if (currentQuantity < transaction.getQuantity()) {
            throw new RuntimeException("An insufficient amount " + fruit + " on balance");
        } else {
            Storage.storageMap.put(fruit, currentQuantity - transaction.getQuantity());
        }
    }
}
