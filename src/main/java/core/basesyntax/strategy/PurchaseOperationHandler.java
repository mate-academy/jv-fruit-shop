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
            throw new RuntimeException("No such fruit");
        }
        if (currentQuantity < transaction.getQuantity()) {
            throw new RuntimeException("fruit's quantity is not enough");
        }
        Storage.storage.put(fruit, currentQuantity - transaction.getQuantity());
    }
}
