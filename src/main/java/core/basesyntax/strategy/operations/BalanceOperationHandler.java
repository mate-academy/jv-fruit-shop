package core.basesyntax.strategy.operations;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Transaction;

public class BalanceOperationHandler implements OperationHandler {
    @Override
    public void handle(Transaction transaction) {
        Storage.fruits.replace(transaction.getProduct(),
                    Storage.fruits.get(transaction.getProduct()) + transaction.getQuantity());
    }
}
