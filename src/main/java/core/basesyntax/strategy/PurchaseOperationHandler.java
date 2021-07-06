package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.dto.Transaction;
import core.basesyntax.model.Fruit;

public class PurchaseOperationHandler implements OperationHandler {
    private static final int DEFAULT_VALUE = 0;

    @Override
    public int apply(Transaction transaction) {
        Fruit fruit = transaction.getFruit();
        int currentQuantity = Storage.storage.getOrDefault(fruit, DEFAULT_VALUE);
        int remainingQuantity = currentQuantity - transaction.getQuantity();
        if (remainingQuantity < 0) {
            throw new RuntimeException("There is no enough " + fruit.getName() + "s");
        }
        Storage.storage.put(transaction.getFruit(), remainingQuantity);
        return transaction.getQuantity();
    }
}
