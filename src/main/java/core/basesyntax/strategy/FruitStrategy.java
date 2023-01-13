package core.basesyntax.strategy;

import core.basesyntax.strategy.impl.BalanceFruitCalculatorService;
import core.basesyntax.strategy.impl.PurchaseFruitCalculatorService;
import core.basesyntax.strategy.impl.ReturnFruitCalculatorService;
import core.basesyntax.strategy.impl.SupplyFruitCalculatorService;
import java.util.HashMap;
import java.util.Map;

public class FruitStrategy {
    private static final Map<String, FruitCalculatorService> keyStorage;

    static {
        keyStorage = new HashMap<>();
        keyStorage.put("b", new BalanceFruitCalculatorService());
        keyStorage.put("p", new PurchaseFruitCalculatorService());
        keyStorage.put("r", new ReturnFruitCalculatorService());
        keyStorage.put("s", new SupplyFruitCalculatorService());
    }

    public FruitCalculatorService getFruitService(String operation) {
        return keyStorage.get(operation);
    }
}
