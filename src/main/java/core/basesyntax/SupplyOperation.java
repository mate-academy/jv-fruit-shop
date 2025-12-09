package core.basesyntax;

import java.util.Map;

public class SupplyOperation implements OperationHandler {

    @Override
    public void apply(FruitTransaction transaction) {
        if (transaction == null) {
            throw new RuntimeException("Transaction cannot be null.");
        }

        String fruit = transaction.getFruit();
        int quantity = transaction.getQuantity();

        if (fruit == null || fruit.isEmpty()) {
            throw new RuntimeException(
                    "Fruit name cannot be null or empty in transaction: " + transaction);
        }

        if (quantity < 0) {
            throw new RuntimeException("Quantity for SUPPLY cannot be negative: " + quantity);
        }

        Map<String, Integer> inventory = Storage.getFruitInventory();

        int currentQuantity = inventory.getOrDefault(fruit, 0);

        int newQuantity = currentQuantity + quantity;

        inventory.put(fruit, newQuantity);
    }
}
