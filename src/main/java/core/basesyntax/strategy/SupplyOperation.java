package core.basesyntax.strategy;

import java.util.HashMap;
import java.util.Map;

public class SupplyOperation implements OperationHandler {
    @Override
    public Map<String, Integer> apply(
            Map<String, Integer> current,
            String fruit,
            int quantity
    ) {
        if (quantity < 0) {
            throw new RuntimeException("Supply quantity cannot be negative");
        }

        Map<String, Integer> result = new HashMap<>(current);
        result.put(
                fruit,
                result.getOrDefault(fruit, 0) + quantity
        );
        return result;
    }
}
