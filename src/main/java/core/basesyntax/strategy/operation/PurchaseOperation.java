package core.basesyntax.strategy.operation;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class PurchaseOperation implements OperationHandler {
    @Override
    public void performOperation(FruitTransaction transaction) {
        int quantityToRemove = -transaction.getQuantity();
        Storage.storage.merge(transaction.getFruitName(), quantityToRemove, Integer::sum);
    }
}
