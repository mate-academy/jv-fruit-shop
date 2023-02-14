package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.Transaction;

public class ReturnOperationHandler implements OperationHandler {
    @Override
    public void apply(Transaction transaction) {
        Fruit fruit = transaction.getFruit();
        int currentQuantity = Storage.storage.get(fruit);
        Storage.storage.put(fruit, currentQuantity + transaction.getQuantity());
    }
}
