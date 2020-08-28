package core.basesyntax.model;

import core.basesyntax.service.FruitOperations;
import core.basesyntax.service.impl.BuyFruitOperation;
import core.basesyntax.service.impl.ReturnFruitOperation;
import core.basesyntax.service.impl.SupplyFruitOperation;

import java.util.HashMap;
import java.util.Map;

public class FruitStorageStrategy {
    public static Map<String, FruitOperations> fruitStorageStrategy = new HashMap<>();

    public static void initialize() {
        fruitStorageStrategy.put("s", new SupplyFruitOperation());
        fruitStorageStrategy.put("b", new BuyFruitOperation());
        fruitStorageStrategy.put("r", new ReturnFruitOperation());
    }
}
