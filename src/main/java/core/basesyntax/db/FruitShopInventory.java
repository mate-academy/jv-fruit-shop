package core.basesyntax.db;

import core.basesyntax.strategy.OperationStrategy;
import java.util.HashMap;
import java.util.Map;

public class FruitShopInventory {

    public static final Map<String, Integer> inventory = new HashMap<>();

    public void applyOperation(OperationStrategy operation, String fruit, int quantity) {
        operation.execute(fruit, quantity);
    }
}
