package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import java.util.Map;

public class PurchaseOperation implements OperationHandler {
    @Override
    public void handle(FruitTransaction transaction, Map<String, Integer> storage) {
        String fruit = transaction.getFruit();
        int quantity = transaction.getQuantity();
        int current = storage.getOrDefault(fruit, 0);
        int result = current - quantity;
        if (result < 0) {
            throw new RuntimeException("Not enough "
                    + fruit + " in storage to purchase: " + quantity);
        }
        storage.put(fruit, result);
    }
}
