package core.basesyntax.strategy.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.TransactionInfo;
import core.basesyntax.strategy.Operation;

public class PurchaseOperationHandlerImpl implements Operation {
    @Override
    public void handle(TransactionInfo fruitTransaction) {
        Integer fruitQuantity = Storage.storage.get(fruitTransaction.getFruit());
        if (fruitQuantity == null) {
            throw new RuntimeException("No fruit available: " + fruitTransaction.getFruit());
        }
        if (fruitQuantity < fruitTransaction.getQuantityFruits()) {
            throw new RuntimeException("No fruit available in sufficient quantity, only - "
                    + fruitQuantity);
        }
        Storage.storage.replace(fruitTransaction.getFruit(),
                fruitQuantity - fruitTransaction.getQuantityFruits());
    }
}
