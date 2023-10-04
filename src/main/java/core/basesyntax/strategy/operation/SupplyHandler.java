package core.basesyntax.strategy.operation;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class SupplyHandler implements OperationHandler {
    @Override
    public void operate(FruitTransaction transaction) {
        int valueBeforeOperation = Storage.storage.getOrDefault(transaction.getFruit(), 0);
        Storage.storage
                .put(transaction.getFruit(), valueBeforeOperation + transaction.getQuantity());
    }
}
