package core.basesyntax.strategy.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.TransactionInfo;
import core.basesyntax.strategy.Operation;

public class ReturnOperationHandlerImpl implements Operation {
    @Override
    public void handle(TransactionInfo fruitTransaction) {
        Integer fruitQuantity = Storage.storage.get(fruitTransaction.getFruit());
        if (fruitQuantity == null) {
            throw new RuntimeException("We don't have fruit for return - "
                    + fruitTransaction.getFruit());
        }
        Storage.storage.replace(fruitTransaction.getFruit(),
                fruitQuantity + fruitTransaction.getQuantityFruits());
    }
}
