package core.basesyntax.model;

import core.basesyntax.operations.BuyOperation;
import core.basesyntax.operations.Operation;
import core.basesyntax.operations.ReturnOperation;
import core.basesyntax.operations.SupplyOperation;
import java.util.HashMap;
import java.util.Map;

public class FruitStrategy {
    public static Map<String, Operation> fruitStorageStrategy = new HashMap<>();

    public static void initialize() {
        fruitStorageStrategy.put("s", new SupplyOperation());
        fruitStorageStrategy.put("b", new BuyOperation());
        fruitStorageStrategy.put("r", new ReturnOperation());
    }
}
