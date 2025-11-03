package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import java.util.Map;

public class PurchaseOperationHandler implements OperationHandler {
    @Override
    public void apply(FruitTransaction transaction, Map<String, Integer> storage) {
        String fruit = transaction.getFruit();
        int quantity = transaction.getQuantity();
        int current = storage.getOrDefault(fruit, 0);

        if (current < quantity) {
            throw new RuntimeException("Not enough " + fruit + " in stock to purchase " + quantity);
        }

        storage.put(fruit, current - quantity);
    }
}
