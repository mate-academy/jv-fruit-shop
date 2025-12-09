package core.basesyntax;

import java.util.Map;

public class BalanceOperation implements OperationHandler {

    @Override
    public void apply(FruitTransaction transaction) {
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
            throw new RuntimeException("Quantity for BALANCE cannot be negative: "
                    + quantity);
        }

        Map<String, Integer> inventory = Storage.getFruitInventory();

        inventory.put(fruit, quantity);
    }
}
