package core.basesyntax;

import java.util.Map;

public class PurchaseOperation implements OperationHandler {
    @Override
    public void handle(FruitTransaction transaction, Map<String, Integer> storage) {
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
