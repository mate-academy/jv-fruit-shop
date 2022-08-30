package core.basesyntax.operation;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class SupplyOperationHandler implements OperationHandler {
    @Override
    public void apply(FruitTransaction transaction) {
        Storage.storage.put(transaction.getFruit(),
                Storage.storage.get(transaction.getFruit()) + transaction.getQuantity());
    }
}
