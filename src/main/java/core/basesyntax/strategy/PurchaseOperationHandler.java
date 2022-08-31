package core.basesyntax.strategy;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.Transaction;
import core.basesyntax.db.Storage;

public class PurchaseOperationHandler implements OperationHandler {
    @Override
    public void apply(Transaction transaction) {
        Fruit fruit = transaction.getFruit();
        Integer currentQuantity = Storage.storage.get(fruit);
        if (fruit == null) {
            throw new RuntimeException("No such fruit");
        }
        if (currentQuantity < transaction.getQuantity()) {
            throw new RuntimeException("fruit's quantity is not enough");
        }
        Storage.storage.put(fruit, currentQuantity - transaction.getQuantity());
    }
}
