package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.transaction.FruitTransaction;

public class SupplyHandler implements OperationHandler {
    @Override
    public void handle(FruitTransaction transaction) {
        int currentQuantity = Storage.storage.getOrDefault(transaction.getFruit(), 0);
        Storage.storage.put(transaction.getFruit(), currentQuantity + transaction.getQuantity());
    }
}
