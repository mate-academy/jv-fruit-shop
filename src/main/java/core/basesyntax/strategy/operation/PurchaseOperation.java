package core.basesyntax.strategy.operation;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class PurchaseOperation implements OperationHandler {
    @Override
    public void performOperation(FruitTransaction transaction) {
        int currentQuantity = Storage.storage.get(transaction.getFruitName());
        Storage.storage.put(transaction.getFruitName(),
                currentQuantity - transaction.getQuantity());
    }
}
