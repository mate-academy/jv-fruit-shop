package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationHandler;
import core.basesyntax.storage.Storage;

public class PurchaseOperationHandler implements OperationHandler {

    @Override
    public void process(FruitTransaction fruitTransaction) throws RuntimeException {
        Integer initialFruitQuantity = Storage.storage.get(fruitTransaction
                .getTransactionFruitName());
        if (initialFruitQuantity == null
                || initialFruitQuantity < fruitTransaction.getQuantity()) {
            throw new RuntimeException("Sorry, this quantity is not available");
        }
        Storage.storage.put(fruitTransaction.getTransactionFruitName(),
                initialFruitQuantity - fruitTransaction.getQuantity());
    }
}
