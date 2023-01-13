package core.basesyntax.operations;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.Transaction;
import core.basesyntax.storage.Storage;

public class PurchaseOperationHandler implements OperationHandler {
    @Override
    public void apply(Transaction transaction) {
        Fruit fruit = transaction.getFruit();
        if (!Storage.storage.containsKey(fruit)) {
            throw new RuntimeException(fruit + " isn't available");
        } else {
            Integer currentQuantity = Storage.storage.get(fruit) - transaction.getSum();
            Storage.storage.put(fruit, currentQuantity);
        }
    }
}
