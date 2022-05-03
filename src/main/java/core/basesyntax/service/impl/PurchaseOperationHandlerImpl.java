package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationHandler;
import core.basesyntax.storage.Storage;

public class PurchaseOperationHandlerImpl implements OperationHandler {

    @Override
    public void process(FruitTransaction fruitTransaction) throws RuntimeException {
        Integer initialFruitQuantity = Storage.storage.get(fruitTransaction
                .getTransactionFruitName());
        if (initialFruitQuantity == null
                || initialFruitQuantity < fruitTransaction.getTransactionFruitQuantity()) {
            throw new RuntimeException("Sorry, this quantity is not available");
        }
        Storage.storage.put(fruitTransaction.getTransactionFruitName(),
                (initialFruitQuantity >= fruitTransaction.getTransactionFruitQuantity()
                ? initialFruitQuantity - fruitTransaction.getTransactionFruitQuantity()
                : initialFruitQuantity == null
                ? 0
                : initialFruitQuantity));
    }
}
