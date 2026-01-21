package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import java.util.Map;

public class ReturnOperation implements OperationHandler {
    @Override
    public void handle(FruitTransaction transaction, Map<String, Integer> map) {
        if (transaction == null || map == null) {
            throw new RuntimeException("Transaction and map cannot be null");
        }

        if (transaction.getFruit().isEmpty()) {
            throw new RuntimeException("Fruit name cannot be null");
        }

        if (transaction.getQuantity() < 0) {
            throw new RuntimeException("Quantity cannot be negative");
        }
        String fruit = transaction.getFruit();

        int currentQuantity = map.getOrDefault(fruit, 0);

        map.put(fruit, currentQuantity + transaction.getQuantity());
    }
}
