package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class SupplyOperationHandler implements OperationHandler {
    @Override
    public void handle(FruitTransaction transaction) {
        int previousQuantity = Storage.getStorageMap().get(transaction.getFruit());
        Storage.getStorageMap().put(transaction.getFruit(),
                previousQuantity + transaction.getQuantity());
    }
}
