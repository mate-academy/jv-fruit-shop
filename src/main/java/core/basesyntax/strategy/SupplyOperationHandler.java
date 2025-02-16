package core.basesyntax.strategy;

import java.util.Map;
import service.InventoryService;

public class SupplyOperationHandler implements OperationHandler {
    @Override
    public void apply(Map<String, Integer> inventory, String fruit, int quantity) {
        InventoryService inventoryService = new InventoryService(inventory);
        inventoryService.addFruit(fruit, quantity);
    }
}
