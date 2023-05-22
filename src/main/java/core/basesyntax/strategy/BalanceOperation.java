package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class BalanceOperation implements OperationHandler {
    @Override
    public void operateTransaction(FruitTransaction transaction, Storage storage) {
        if (transaction.getQuantity() < 0) {
            throw new RuntimeException("Balance should be positive.");
        }
        storage.put(transaction.getFruit(), transaction.getQuantity());
    }
}
