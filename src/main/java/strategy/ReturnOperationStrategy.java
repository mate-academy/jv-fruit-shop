package strategy;

import java.util.Map;

public class ReturnOperationStrategy implements OperationStrategy {
    @Override
    public void execute(String fruit, int quantity, Map<String, Integer> fruitQuantities) {
        fruitQuantities.put(fruit, fruitQuantities.getOrDefault(fruit, 0) + quantity);
    }
}
