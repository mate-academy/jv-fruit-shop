package core.basesyntax.strategy;

import java.util.Map;

public class Supply implements OperationStrategy {
    @Override
    public void execute(Map<String, Integer> inventory, String fruit, int quantity) {
        inventory.put(fruit, inventory.getOrDefault(fruit, 0) + quantity);
    }
}
