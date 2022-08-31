package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.Transaction;
import java.util.NoSuchElementException;

public class PurchaseOperationHandler implements OperationHandler {
    @Override
    public void apply(Transaction transaction) {
        Fruit fruit = transaction.getFruit();
        Integer currentQuantity = Storage.get(fruit);
        if (currentQuantity == null || currentQuantity < transaction.getQuantity()) {
            throw new NoSuchElementException("Quantity of fruits is not enough for purchase");
        }
        Storage.put(fruit, currentQuantity - transaction.getQuantity());
    }
}
