package core.basesyntax.strategy.impl;

import core.basesyntax.strategy.OperationHandler;
import java.util.Map;

public class PurchaseOperation implements OperationHandler {
    @Override
    public void apply(String fruit, int quantity, Map<String, Integer> storage) {
        int currentQuantity = storage.getOrDefault(fruit, 0);
        int updatedQuantity = currentQuantity - quantity;

        if (updatedQuantity < 0) {
            throw new RuntimeException("Not enough " + fruit + " in storage. Current: "
                    + currentQuantity + ", trying to remove: " + quantity);
        }

        storage.put(fruit, updatedQuantity);
    }
}
