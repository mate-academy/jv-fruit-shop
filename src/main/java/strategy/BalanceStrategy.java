package strategy;

import java.util.Map;

public class BalanceStrategy implements OperationStrategy {
    @Override
    public void apply(Map<String, Integer> fruitCounts, String fruit, int quantity) {
        fruitCounts.put(fruit, fruitCounts.getOrDefault(fruit, 0) + quantity);
    }
}
