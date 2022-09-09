package core.basesyntax.strategy.impl;

import core.basesyntax.model.Transaction;
import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.strategy.OperationHandler;

public class SubtractOperationHandler implements OperationHandler {
    @Override
    public void perform(Transaction transaction) {
        Fruit fruit = transaction.getFruit();
        Integer currentQuantity = Storage.storage.get(fruit);
        if (currentQuantity <= 0) {
            throw new RuntimeException("Insufficient storage resources");
        }
        Storage.storage.put(fruit, currentQuantity - transaction.getQuantity());
    }
}
