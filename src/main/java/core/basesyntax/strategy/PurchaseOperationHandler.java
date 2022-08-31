package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.Transaction;

public class PurchaseOperationHandler implements OperationHandler {
    @Override
    public void apply(Transaction transaction) {
        Fruit fruit = transaction.getFruit();
        Integer currentQuantity = Storage.storage.get(fruit);
        if (currentQuantity == null) {
            throw new RuntimeException("We don't have fruit - " + fruit);
        }
        if (currentQuantity >= transaction.getQuantity()) {
            Storage.storage.put(fruit, currentQuantity - transaction.getQuantity());
        } else {
            throw new RuntimeException("There is not enough fruit "
                    + fruit + " on balance for this purchase operation");
        }
    }
}
