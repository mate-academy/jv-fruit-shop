package core.basesyntax;

import java.util.Map;

public class PurchaseOperation implements OperationHandler {
    private final Map<String, Integer> storage;

    public PurchaseOperation(Map<String, Integer> storage) {
        this.storage = storage;
    }

    @Override
    public void handle(FruitTransaction transaction) {
        int currentQuantity = storage.getOrDefault(transaction.getFruit(), 0);
        int quantity = transaction.getQuantity();

        if (quantity < 0) {
            throw new IllegalArgumentException("Invalid quantity: " + quantity);
        }
        if (currentQuantity < quantity) {
            throw new IllegalArgumentException(
                    "Not enough fruit in storage for purchase: " + transaction.getFruit());
        }
        storage.put(transaction.getFruit(), currentQuantity - quantity);
    }
}
