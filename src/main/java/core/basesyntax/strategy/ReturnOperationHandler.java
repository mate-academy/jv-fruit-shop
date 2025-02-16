package core.basesyntax.strategy;

import java.util.Map;

public class ReturnOperationHandler implements OperationHandler {
    @Override
    public void apply(Map<String, Integer> inventory, String fruit, int quantity) {
        inventory.put(fruit, inventory.getOrDefault(fruit, 0) + quantity);
    }
}
