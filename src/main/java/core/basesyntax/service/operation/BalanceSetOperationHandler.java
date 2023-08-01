package core.basesyntax.service.operation;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class BalanceSetOperationHandler implements OperationHandler {
    @Override
    public void executeOperation(FruitTransaction transaction) {
        Storage.STORAGE.put(transaction.getFruitName(), transaction.getAmount());
    }
}
