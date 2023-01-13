package core.basesyntax.operations;

import core.basesyntax.model.Transaction;
import core.basesyntax.storage.Storage;

public class PurchaseOperationHandler implements OperationHandler {
    @Override
    public void apply(Transaction transaction) {
        String fruit = transaction.getFruit();
        if (Storage.storage.containsKey(fruit)) {
            Integer currentQuantity = Storage.storage.get(fruit) - transaction.getSum();
            Storage.storage.put(fruit, currentQuantity);
        } else {
            throw new RuntimeException(fruit + " isn't available");
        }
    }
}
