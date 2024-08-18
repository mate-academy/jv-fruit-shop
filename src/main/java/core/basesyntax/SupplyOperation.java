package core.basesyntax;

import java.util.Map;

public class SupplyOperation implements OperationHandler {
    private final Map<String, Integer> storage;

    public SupplyOperation(Map<String, Integer> storage) {
        this.storage = storage;
    }

    @Override
    public void handle(FruitTransaction transaction) {
        int quantity = transaction.getQuantity();
        if (quantity < 0) {
            throw new IllegalArgumentException("Invalid quantity: " + quantity);
        }
        storage.put(transaction.getFruit(),
                storage.getOrDefault(transaction.getFruit(), 0) + quantity);
    }
}
