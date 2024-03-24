package core.basesyntax.strategy.operation;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class PurchaseHandler implements OperationHandler {
    @Override
    public void getOperation(FruitTransaction transaction) {
        int valueBeforeOperation = Storage.storage.get(transaction.getFruit());
        if (valueBeforeOperation - transaction.getQuantity() <= 0) {
            throw new RuntimeException("Balance after purchase will be negative");
        }
        Storage.storage
                .put(transaction.getFruit(), valueBeforeOperation - transaction.getQuantity());
    }
}
