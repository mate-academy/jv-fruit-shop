package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.Transaction;

public class SupplyOperationHandler implements OperationHandler {
    @Override
    public void apply(Transaction transaction) {
        Fruit fruit = transaction.getFruit();
        Integer currentQuantity = Storage.get(fruit);
        Storage.put(fruit, (currentQuantity == null ? 0
                : currentQuantity) + transaction.getQuantity());
    }
}
