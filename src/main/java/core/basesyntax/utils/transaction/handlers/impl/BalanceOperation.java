package core.basesyntax.utils.transaction.handlers.impl;

import core.basesyntax.storage.impl.StorageImpl;
import core.basesyntax.utils.transaction.FruitTransaction;
import core.basesyntax.utils.transaction.handlers.OperationHandler;

public class BalanceOperation implements OperationHandler {
    public void perform(FruitTransaction transaction, StorageImpl storage) {
        storage.updateEntry(transaction.getProduct(), transaction.getQuantity());
    }
}
