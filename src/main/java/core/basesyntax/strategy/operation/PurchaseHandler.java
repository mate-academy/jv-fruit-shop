package core.basesyntax.strategy.operation;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class PurchaseHandler implements OperationHandler {
    @Override
    public void getOperation(FruitTransaction transaction) {
        if (Storage.storage.get(transaction.getFruit()) - transaction.getQuantity() > 0) {
            int valueBeforeOperation = Storage.storage.get(transaction.getFruit());
            Storage.storage
                    .put(transaction.getFruit(), valueBeforeOperation - transaction.getQuantity());
        } else {
            throw new RuntimeException("Balance after purchase will be negative");
        }
    }
}
