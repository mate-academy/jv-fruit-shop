package core.basesyntax.strategy;

import java.util.HashMap;
import java.util.Map;

public class PurchaseOperation implements OperationHandler {
    @Override
    public Map<String, Integer> apply(
            Map<String, Integer> current,
            String fruit,
            int quantity
    ) {
        if (quantity < 0) {
            throw new RuntimeException("Purchase quantity cannot be negative");
        }

        int currentAmount = current.getOrDefault(fruit, 0);
        int resultAmount = currentAmount - quantity;

        if (resultAmount < 0) {
            throw new RuntimeException(
                    "Not enough " + fruit + " in storage");
        }

        Map<String, Integer> result = new HashMap<>(current);
        result.put(fruit, resultAmount);
        return result;
    }
}
