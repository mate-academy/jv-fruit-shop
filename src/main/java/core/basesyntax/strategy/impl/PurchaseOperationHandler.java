package core.basesyntax.strategy.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class PurchaseOperationHandler implements OperationHandler {

    @Override
    public void applyChanges(FruitTransaction fruitTransaction) {
        if (fruitTransaction.getQuantity()
                > Storage.storage.get(fruitTransaction.getNameOfFruit())) {
            throw new RuntimeException("There are not enough fruits");
        }
        if (fruitTransaction.getQuantity() < 0) {
            throw new RuntimeException("Purchase can`t be negative");
        }
        Storage.storage.put(fruitTransaction.getNameOfFruit(),
                Storage.storage.get(fruitTransaction.getNameOfFruit())
                        - fruitTransaction.getQuantity());
    }
}
