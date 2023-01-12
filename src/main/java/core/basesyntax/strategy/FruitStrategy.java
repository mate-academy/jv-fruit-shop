package core.basesyntax.strategy;

import core.basesyntax.strategy.impl.BalanceImpl;
import core.basesyntax.strategy.impl.PurchaseImpl;
import core.basesyntax.strategy.impl.ReturnImpl;
import core.basesyntax.strategy.impl.SupplyImpl;
import java.util.HashMap;
import java.util.Map;

public class FruitStrategy {
    private static final Map<String, FruitCalculatorService> keyStorage;

    static {
        keyStorage = new HashMap<>();
        keyStorage.put("b", new BalanceImpl());
        keyStorage.put("p", new PurchaseImpl());
        keyStorage.put("r", new ReturnImpl());
        keyStorage.put("s", new SupplyImpl());
    }

    public FruitCalculatorService getFruitService(String operation) {
        return keyStorage.get(operation);
    }
}
