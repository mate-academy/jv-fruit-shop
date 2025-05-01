package core.basesyntax.data.strategy;

import java.util.Map;

public class SupplyOperationHandler implements OperationHandler {
    @Override
    public void apply(Map<String, Integer> inventory, String fruit, int quantity) {
        int currentQuantity = inventory.getOrDefault(fruit, 0);
        inventory.put(fruit, currentQuantity + quantity);
    }

}
