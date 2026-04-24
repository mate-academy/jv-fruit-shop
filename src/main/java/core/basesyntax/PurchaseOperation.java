package core.basesyntax;

import java.util.Map;

public class PurchaseOperation implements OperationHandler {
    @Override
    public void apply(String fruit, int quantity, Map<String, Integer> storage) {
        int current = storage.getOrDefault(fruit, 0);

        if (current < quantity) {
            throw new RuntimeException("Not enough " + fruit + " in stock. Available: "
                    + current + ", requested: " + quantity);
        }
        storage.put(fruit, current - quantity);
    }
}
