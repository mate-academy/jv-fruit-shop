package core.basesyntax;

import core.basesyntax.operation.Buy;
import core.basesyntax.operation.Operation;
import core.basesyntax.operation.Return;
import core.basesyntax.operation.Supply;
import java.util.HashMap;
import java.util.Map;

public class FruitStorageStrategy {
    public static Map<String, Operation> fruitStorageStrategy = new HashMap<>();

    public static void initialize() {
        FruitStorageStrategy.fruitStorageStrategy.put("s", new Supply());
        FruitStorageStrategy.fruitStorageStrategy.put("b", new Buy());
        FruitStorageStrategy.fruitStorageStrategy.put("r", new Return());
    }
}
