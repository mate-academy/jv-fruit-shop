package core.basesyntax.strategy;

import core.basesyntax.exception.FruitShopException;
import core.basesyntax.strategy.impl.BalanceFruitCalculatorService;
import core.basesyntax.strategy.impl.PurchaseFruitCalculatorService;
import core.basesyntax.strategy.impl.ReturnFruitCalculatorService;
import core.basesyntax.strategy.impl.SupplyFruitCalculatorService;
import java.util.HashMap;
import java.util.Map;

public class FruitStrategy {
    public static final Map<String, FruitCalculatorService> keyStorage;

    static {
        keyStorage = new HashMap<>();
        keyStorage.put("b", new BalanceFruitCalculatorService());
        keyStorage.put("p", new PurchaseFruitCalculatorService());
        keyStorage.put("r", new ReturnFruitCalculatorService());
        keyStorage.put("s", new SupplyFruitCalculatorService());
    }

    public FruitCalculatorService getFruitService(String operation) {
        if (operation == null || operation.isEmpty()) {
            throw new FruitShopException("String operation should not be null or empty");
        }
        if (!keyStorage.containsKey(operation)) {
            throw new FruitShopException("Operation is wrong");
        }
        return keyStorage.get(operation);
    }
}
