package core.basesyntax.strategy.handlers;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;

public class PurchaseOperationHandler implements OperationHandler {
    @Override
    public void apply(FruitTransaction transaction) {
        Fruit fruit = transaction.getFruit();
        Integer currentQuantity = Storage.storage.get(fruit);
        if (currentQuantity == null || currentQuantity < transaction.getQuantity()) {
            throw new RuntimeException("Product is out of stock");
        }
        Storage.storage.put(fruit, currentQuantity - transaction.getQuantity());
    }
}

