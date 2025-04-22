package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.Storage;

public class PurchaseOperation implements OperationHandler {
    @Override
    public void handle(FruitTransaction transaction) {
        String fruit = transaction.getFruit();
        int quantity = transaction.getQuantity();
        int current = Storage.getStorage().getOrDefault(fruit, 0);
        int result = current - quantity;
        if (result < 0) {
            throw new RuntimeException("Not enough "
                    + fruit + " in storage to purchase: " + quantity);
        }
        Storage.getStorage().put(fruit, result);
    }
}
