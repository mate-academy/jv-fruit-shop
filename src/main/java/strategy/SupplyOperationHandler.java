package strategy;

import java.util.Map;
//SupplyOperationHandler
public class SupplyOperationHandler implements OperationHandler {
    @Override
    public void apply(Map<String, Integer> inventory, String fruit, int quantity) {
        inventory.put(fruit, inventory.getOrDefault(fruit, 0) + quantity);
    }
}
