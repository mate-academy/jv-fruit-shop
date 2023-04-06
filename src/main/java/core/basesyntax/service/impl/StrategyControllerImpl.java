package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.StrategyController;
import core.basesyntax.strategy.FruitShopStrategy;

import java.util.HashMap;
import java.util.Map;

public class StrategyControllerImpl implements StrategyController {
    private final Map<FruitTransaction.Operation, FruitShopStrategy> strategyMap = new HashMap<>();

    @Override
    public void setStrategy(FruitTransaction.Operation key, FruitShopStrategy strategy) {
        this.strategyMap.put(key, strategy);
    }

    @Override
    public FruitShopStrategy getStrategy(FruitTransaction.Operation key) {
        return strategyMap.get(key);
    }
}
