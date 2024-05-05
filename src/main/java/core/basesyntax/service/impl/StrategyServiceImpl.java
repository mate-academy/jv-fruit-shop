package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.StrategyService;
import core.basesyntax.strategy.StrategyHandler;
import java.util.Map;

public class StrategyServiceImpl implements StrategyService {
    private final Map<FruitTransaction.Operation, StrategyHandler> strategyHandlerMap;

    public StrategyServiceImpl(Map<FruitTransaction.Operation,
            StrategyHandler> strategyHandlerMap) {
        this.strategyHandlerMap = strategyHandlerMap;
    }

    @Override
    public StrategyHandler getStrategy(FruitTransaction.Operation operation) {
        return strategyHandlerMap.get(operation);
    }
}
