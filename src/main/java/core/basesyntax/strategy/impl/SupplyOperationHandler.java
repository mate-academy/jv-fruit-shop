package core.basesyntax.strategy.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class SupplyOperationHandler implements OperationHandler {

    @Override
    public void applyChanges(FruitTransaction fruitTransaction) {
        if (fruitTransaction.getQuantity() < 0) {
            throw new RuntimeException("Supply cannot be negative");
        }
        int fruitQuantity = Storage.storage.get(fruitTransaction.getNameOfFruit())
                == null ? 0 : Storage.storage.get(fruitTransaction.getNameOfFruit());
        Storage.storage.put(fruitTransaction.getNameOfFruit(),
                fruitQuantity + fruitTransaction.getQuantity());
    }
}
