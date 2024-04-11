package strategy;

import java.util.Map;

public class PurchaseStrategy implements OperationStrategy {
    @Override
    public void apply(Map<String, Integer> fruitCounts, String fruit, int quantity) {
        if (fruitCounts.getOrDefault(fruit, 0) < quantity) {
            throw new RuntimeException("Not enough " + fruit + " in the store");
        } else {
            fruitCounts.put(fruit, fruitCounts.getOrDefault(fruit, 0) - quantity);
        }
    }
}
