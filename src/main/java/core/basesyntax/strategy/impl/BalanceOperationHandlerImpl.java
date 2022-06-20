package core.basesyntax.strategy.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.TransactionInfo;
import core.basesyntax.strategy.Operation;

public class BalanceOperationHandlerImpl implements Operation {
    @Override
    public void handle(TransactionInfo fruitTransaction) {
        Storage.storage.put(fruitTransaction.getFruit(), fruitTransaction.getQuantityFruits());
    }
}
