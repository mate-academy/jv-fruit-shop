package strategy;

import java.util.Map;

public class PurchaseOperationStrategy implements OperationStrategy {
    @Override
    public void execute(String fruit, int quantity, Map<String, Integer> fruitQuantities) {
        int currentQuantity = fruitQuantities.getOrDefault(fruit, 0);
        if (currentQuantity < quantity) {
            throw new RuntimeException("Not enough " + fruit + " in stock to make purchase.");
        }
        fruitQuantities.put(fruit, currentQuantity - quantity);
    }
}
