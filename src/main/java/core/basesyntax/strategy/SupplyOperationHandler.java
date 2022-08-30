package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.Transaction;

public class SupplyOperationHandler implements OperationHandler {
    @Override
    public void apply(Transaction transaction) {
        Fruit fruit = transaction.getFruit();
        if (!Storage.getFruitsMap().containsKey(fruit)) {
            Storage.getFruitsMap().put(fruit, transaction.getQuantity());
        } else {
            Integer currentQuantity = Storage.getFruitsMap().get(fruit);
            Storage.getFruitsMap().put(fruit, currentQuantity + transaction.getQuantity());
        }
    }
}
