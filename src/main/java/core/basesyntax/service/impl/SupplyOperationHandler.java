package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationHandler;
import core.basesyntax.storage.Storage;

public class SupplyOperationHandler implements OperationHandler {
    @Override
    public void process(FruitTransaction fruitTransaction) {
        Integer initialFruitQuantity = Storage.storage.get(fruitTransaction
                .getTransactionFruitName());
        Storage.storage.put(fruitTransaction.getTransactionFruitName(), initialFruitQuantity == null
                ? fruitTransaction.getQuantity()
                : initialFruitQuantity + fruitTransaction.getQuantity());
    }
}
