package core.basesyntax;

import java.util.Map;

public class SupplyOperation implements OperationHandler {
    @Override
    public void handle(FruitTransaction transaction, Map<String, Integer> storage) {
        int quantity = transaction.getQuantity();
        if (quantity < 0) {
            throw new IllegalArgumentException("Invalid quantity: " + quantity);
        }
        storage.put(transaction.getFruit(),
                storage.getOrDefault(transaction.getFruit(), 0) + quantity);
    }
}
