package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class BalanceOperation implements OperationHendler {
    @Override
    public void operateTransaction(FruitTransaction transaction) {
        if (transaction.getQuantity() < 0) {
            throw new RuntimeException("Balance should be positive.");
        }
        Storage.fruitStorage.put(transaction.getFruit(),transaction.getQuantity());
    }
}
