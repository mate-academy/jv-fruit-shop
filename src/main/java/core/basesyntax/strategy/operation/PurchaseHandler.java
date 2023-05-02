package core.basesyntax.strategy.operation;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class PurchaseHandler implements OperationHandler {
    @Override
    public void operate(FruitTransaction transaction) {
        if (Storage.storage.get(transaction.getFruit()) - transaction.getQuantity() > 0) {
            int valueBeforeOperation = Storage.storage.getOrDefault(transaction.getFruit(), 0);
            Storage.storage
                    .put(transaction.getFruit(), valueBeforeOperation - transaction.getQuantity());
        } else {
            throw new RuntimeException("Balance after purchase will be negative");
        }
    }
}
