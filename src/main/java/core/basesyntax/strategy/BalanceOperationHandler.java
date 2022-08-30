package core.basesyntax.strategy;

import core.basesyntax.model.Transaction;
import core.basesyntax.storage.Storage;

public class BalanceOperationHandler implements OperationHandler {
    @Override
    public void apply(Transaction transaction) {
        Storage.storage.put(transaction.getFruit(),
                (Storage.storage.get(transaction.getFruit()) == null ? 0
                : Storage.storage.get(transaction.getFruit())) + transaction.getQuantity());
    }
}
