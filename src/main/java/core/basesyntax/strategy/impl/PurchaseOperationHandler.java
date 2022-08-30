package core.basesyntax.strategy.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.Transaction;
import core.basesyntax.storage.Storage;
import core.basesyntax.strategy.OperationHandler;

public class PurchaseOperationHandler implements OperationHandler {
    @Override
    public void apply(Transaction transaction) {
        Fruit fruit = transaction.getFruit();
        Integer currentQuantity = Storage.storage.get(fruit);
        Integer transactionQuantity = transaction.getQuantity();
        if (currentQuantity < transactionQuantity) {
            throw new RuntimeException("There is not enough fruit in the warehouse");
        }
        Storage.storage.put(fruit, currentQuantity - transactionQuantity);
    }
}
