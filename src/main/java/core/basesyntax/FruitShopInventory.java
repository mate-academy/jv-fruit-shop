package core.basesyntax;

import java.util.HashMap;
import java.util.Map;

public class FruitShopInventory {
    private Map<String, Integer> inventory = new HashMap<>();

    public void applyOperation(OperationStrategy operation, String fruit, int quantity) {
        operation.execute(inventory, fruit, quantity);
    }

    public Map<String, Integer> getInventory() {
        return inventory;
    }
}