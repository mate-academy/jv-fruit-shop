package core.basesyntax.strategy.impl;

import core.basesyntax.handler.Handler;
import core.basesyntax.models.FruitTransition;
import core.basesyntax.strategy.Strategy;
import java.util.HashMap;
import java.util.Map;

public class StrategyImpl implements Strategy {
    private Map<FruitTransition.Operation, Handler> operationsMap = new HashMap<>();

    public StrategyImpl(Map<FruitTransition.Operation, Handler> operationsMap) {
        this.operationsMap = operationsMap;
    }

    @Override
    public Handler get(FruitTransition.Operation operation) {
        return operationsMap.get(operation);
    }
}
