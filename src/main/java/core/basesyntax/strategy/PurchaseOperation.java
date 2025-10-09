package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import java.util.Map;

public class PurchaseOperation implements OperationHandler {

    @Override
    public void handle(FruitTransaction transaction, Map<String, Integer> stock) {
        if (transaction == null) {
            throw new RuntimeException("Transaction cannot be null");
        }
        if (stock == null) {
            throw new RuntimeException("Stock map cannot be null");
        }

        String fruit = transaction.getFruit();
        Integer quantity = transaction.getQuantity();

        if (fruit == null || fruit.trim().isEmpty()) {
            throw new RuntimeException("Fruit name cannot be null or empty");
        }
        if (quantity == null || quantity < 0) {
            throw new RuntimeException("Quantity must be a non-negative integer");
        }

        fruit = fruit.trim();

        int current = stock.getOrDefault(fruit, 0);
        int newBalance = current - quantity;

        if (newBalance < 0) {
            throw new RuntimeException(String.format(
                    "Insufficient stock for purchase: fruit=%s, requested=%d, available=%d",
                    fruit, quantity, current));
        }
        stock.put(fruit, newBalance);
    }
}
