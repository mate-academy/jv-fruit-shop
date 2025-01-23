package core.basesyntax.model.handler;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class SupplyOperation implements OperationHandler {
    @Override
    public void handle(FruitTransaction transaction) {
        Storage.storage.put(transaction.getFruit(),
                Storage.storage.getOrDefault(transaction.getFruit(), 0)
                        + transaction.getQuantity());
    }
}
