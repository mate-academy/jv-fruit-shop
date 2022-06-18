package core.basesyntax.strategy.impl;

import core.basesyntax.dp.Storage;
import core.basesyntax.model.TransactionInfo;
import core.basesyntax.strategy.OperationHandler;

public class BalanceOperationHandlerImpl implements OperationHandler {
    @Override
    public void handle(TransactionInfo fruitTransaction) {
        Storage.storage.put(fruitTransaction.getFruit(), fruitTransaction.getQuantityFruits());
    }
}
