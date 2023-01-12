package core.basesyntax.strategy;

import java.util.HashMap;
import java.util.Map;

public class FruitStrategyImpl {
    public FruitService getFruitService(String operation) {
        Map<String, FruitService> keyStorage = new HashMap<>();
        keyStorage.put("b", new Balance());
        keyStorage.put("p", new Purchase());
        keyStorage.put("r", new Return());
        keyStorage.put("s", new Supply());
        return keyStorage.get(operation);
    }
}
