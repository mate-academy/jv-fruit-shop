package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class PurchaseHandler implements OperationHandler {
    @Override
    public void operateTransaction(FruitTransaction transaction, Storage storage) {
        int oldQuantity = storage.get(transaction.getFruit());
        if (transaction.getQuantity() > oldQuantity) {
            throw new RuntimeException("Don't have enough fruits.");
        }
        storage.put(transaction.getFruit(), oldQuantity - transaction.getQuantity());
    }
}
