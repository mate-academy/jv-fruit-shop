package core.basesyntax.strategy.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.Transaktion;
import core.basesyntax.storage.Storage;
import core.basesyntax.strategy.OperationHandler;

public class PurchaseOperationHandler implements OperationHandler {
    @Override
    public void apply(Transaktion transaktion) {
        Fruit fruit = transaktion.getFruit();
        Integer currentQuantity = Storage.storage.get(fruit);
        if (currentQuantity >= transaktion.getQuantity()) {
            Storage.storage.put(fruit, currentQuantity - transaktion.getQuantity());
        } else {
            throw new RuntimeException("Quantity " + fruit.getName() + " is not enough");
        }

    }
}
