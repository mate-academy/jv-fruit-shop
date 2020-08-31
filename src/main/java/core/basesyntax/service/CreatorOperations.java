package core.basesyntax.service;

import java.util.HashMap;
import java.util.Map;

public class CreatorOperations {
    private static final String BUY = "b";
    private static final String SUPPLY = "s";
    private static final String RETURN = "r";

    public static Map<String, FruitOperations> createOperation() {
        Map<String, FruitOperations> fruitOperationMap = new HashMap<>();
        fruitOperationMap.put(RETURN, new SupplyAndReturnOperation());
        fruitOperationMap.put(SUPPLY, new SupplyAndReturnOperation());
        fruitOperationMap.put(BUY, new BuyOperation());
        return fruitOperationMap;
    }
}
