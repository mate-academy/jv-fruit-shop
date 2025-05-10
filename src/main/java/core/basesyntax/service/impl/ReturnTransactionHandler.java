package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.TransactionHandler;

public class ReturnTransactionHandler implements TransactionHandler {
    @Override
    public void process(FruitTransaction transaction) {
        Storage.storage.replace(
                transaction.getFruit(),
                Storage.storage.get(transaction.getFruit()) + transaction.getQuantity());
    }
}
