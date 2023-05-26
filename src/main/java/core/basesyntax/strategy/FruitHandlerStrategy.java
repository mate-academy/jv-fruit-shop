package core.basesyntax.strategy;

import core.basesyntax.enumeration.Operation;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.impl.BalanceFruitHandlerImpl;
import core.basesyntax.strategy.impl.PurchaseFruitHandlerImpl;
import core.basesyntax.strategy.impl.ReturnFruitHandlerImpl;
import core.basesyntax.strategy.impl.SupplyFruitHandlerImpl;
import java.util.HashMap;
import java.util.Map;

public class FruitHandlerStrategy {
    private final Map<Operation, FruitHandler> fruitStrategyMap = new HashMap<>() {{
            put(Operation.BALANCE, new BalanceFruitHandlerImpl());
            put(Operation.SUPPLY, new SupplyFruitHandlerImpl());
            put(Operation.PURCHASE, new PurchaseFruitHandlerImpl());
            put(Operation.RETURN, new ReturnFruitHandlerImpl());
            }};

    public FruitHandler get(FruitTransaction fruitTransaction) {
        return fruitStrategyMap.get(fruitTransaction.getOperation());
    }
}
