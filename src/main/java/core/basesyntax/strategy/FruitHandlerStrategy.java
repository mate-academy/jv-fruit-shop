package core.basesyntax.strategy;

import core.basesyntax.enumeration.Operation;
import core.basesyntax.model.FruitTransaction;
import java.util.Map;

public class FruitHandlerStrategy {
    private final Map<Operation, FruitHandler> fruitStrategyMap;

    public FruitHandlerStrategy(Map<Operation, FruitHandler> fruitStrategyMap) {
        this.fruitStrategyMap = fruitStrategyMap;
    }

    public FruitHandler get(FruitTransaction fruitTransaction) {
        return fruitStrategyMap.get(fruitTransaction.getOperation());
    }
}
