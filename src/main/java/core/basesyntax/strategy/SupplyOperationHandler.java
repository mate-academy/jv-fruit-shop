package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class SupplyOperationHandler implements OperationHandler {
    @Override
    public void handleTransaction(FruitTransaction fruitTransaction) {
        Storage.getStorageFruit().put(fruitTransaction.getFruit(),
                Storage.getStorageFruit().getOrDefault(fruitTransaction.getFruit(), 0)
                        + fruitTransaction.getQuantity());
    }
}
