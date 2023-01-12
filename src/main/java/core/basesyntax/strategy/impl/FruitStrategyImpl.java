package core.basesyntax.strategy.impl;

import core.basesyntax.strategy.FruitService;
import java.util.HashMap;
import java.util.Map;

public class FruitStrategyImpl {
    private static final Map<String, FruitService> keyStorage;

    static {
        keyStorage = new HashMap<>();
        keyStorage.put("b", new BalanceImpl());
        keyStorage.put("p", new PurchaseImpl());
        keyStorage.put("r", new ReturnImpl());
        keyStorage.put("s", new SupplyImpl());
    }

    public FruitService getFruitService(String operation) {
        return keyStorage.get(operation);
    }
}
