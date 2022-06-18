package core.basesyntax.strategy.impl;

import core.basesyntax.dp.Storage;
import core.basesyntax.model.TransactionInfo;
import core.basesyntax.strategy.OperationHandler;

public class ReturnOperationHandlerImpl implements OperationHandler {
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
