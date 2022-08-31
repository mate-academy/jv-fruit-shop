package core.basesyntax.strategy.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.Transaction;
import core.basesyntax.storage.Storage;
import core.basesyntax.strategy.OperationHandler;

public class PurchaseOperationHandler implements OperationHandler {
    @Override
    public void apply(Transaction transaction) {
        Fruit fruit = transaction.getFruit();
        Integer currentQuantity = Storage.storage.get(fruit);
        if (currentQuantity >= transaction.getQuantity()) {
            Storage.storage.put(fruit, currentQuantity - transaction.getQuantity());
        } else {
            throw new RuntimeException("Quantity " + fruit.getName() + " is not enough");
        }
    }
}
