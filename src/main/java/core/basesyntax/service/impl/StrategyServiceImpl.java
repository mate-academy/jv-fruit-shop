package core.basesyntax.service.impl;

import core.basesyntax.service.StrategyService;
import core.basesyntax.strategy.StrategyHandler;
import java.util.Map;

public class StrategyServiceImpl implements StrategyService {
    private final Map<String, StrategyHandler> strategyHandlerMap;

    public StrategyServiceImpl(Map<String, StrategyHandler> stringStrategyHandlerMap) {
        this.strategyHandlerMap = stringStrategyHandlerMap;
    }

    @Override
    public StrategyHandler getStrategy(String typeStrategy) {
        return strategyHandlerMap.get(typeStrategy);
    }
}
