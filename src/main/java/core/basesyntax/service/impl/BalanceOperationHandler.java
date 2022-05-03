package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationHandler;
import core.basesyntax.storage.Storage;

public class BalanceOperationHandler implements OperationHandler {

    @Override
    public void process(FruitTransaction fruitTransaction) {
        Storage.storage.put(fruitTransaction.getTransactionFruitName(),
                fruitTransaction.getQuantity());
    }
}
