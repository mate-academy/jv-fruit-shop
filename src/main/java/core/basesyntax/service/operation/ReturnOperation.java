package core.basesyntax.service.operation;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import java.util.Map;

public class ReturnOperation implements OperationHandler {
    @Override
    public void apply(FruitTransaction transaction) {
        // --- WALIDACJA WEJŚCIA START ---
        if (transaction == null) {
            throw new RuntimeException("Transaction cannot be null.");
        }

        String fruit = transaction.getFruit();
        int quantity = transaction.getQuantity();

        if (fruit == null || fruit.isEmpty()) {
            throw new RuntimeException("Fruit name cannot be null or empty in transaction: "
                    + transaction);
        }

        if (quantity < 0) {
            throw new RuntimeException("Quantity for RETURN cannot be negative: "
                    + quantity);
        }

        Map<String, Integer> inventory = Storage.getFruitStorage();

        int currentQuantity = inventory.getOrDefault(fruit, 0);
        int newQuantity = currentQuantity + quantity;

        inventory.put(fruit, newQuantity);
    }
}
