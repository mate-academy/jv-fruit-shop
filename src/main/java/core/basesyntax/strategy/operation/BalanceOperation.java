package core.basesyntax.strategy.operation;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class BalanceOperation implements OperationHandler {
    @Override
    public void performOperation(FruitTransaction transaction) {
        Storage.getStorage().put(transaction.getFruitName(), transaction.getQuantity());
    }
}
