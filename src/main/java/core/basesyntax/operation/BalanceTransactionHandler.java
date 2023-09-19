package core.basesyntax.operation;

import core.basesyntax.FruitTransaction;
import core.basesyntax.storage.Storage;

public class BalanceTransactionHandler implements TransactionHandler {
    @Override
    public void applyTransaction(FruitTransaction transaction) {
        Storage.storage.put(transaction.getFruit(), transaction.getQuantity());
    }
}
