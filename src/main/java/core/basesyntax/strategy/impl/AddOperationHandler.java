package core.basesyntax.strategy.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.Transaction;
import core.basesyntax.strategy.OperationHandler;

public class AddOperationHandler implements OperationHandler {
    @Override
    public void perform(Transaction transaction) {
        Fruit fruit = transaction.getFruit();
        Integer currentQuantity = Storage.storage.get(fruit);
        Storage.storage.put(fruit, (currentQuantity == null ? 0 : currentQuantity)
                + transaction.getQuantity());
    }
}
