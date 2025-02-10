package core.basesyntax.operation;

import core.basesyntax.FruitTransaction;
import core.basesyntax.db.Storage;

public class PurchaseOperation implements OperationHandler {
    @Override
    public void apply(FruitTransaction transaction) {
        String fruit = transaction.getFruit();
        int quantity = transaction.getQuantity();
        int storageQuantity = Storage.fruitStorage.getOrDefault(fruit, 0);
        if (quantity > storageQuantity) {
            throw new IllegalArgumentException("We don't have " + quantity + fruit
                    + "'s . we have only " + storageQuantity);
        }
        Storage.fruitStorage.put(fruit, storageQuantity - quantity);
    }
}
