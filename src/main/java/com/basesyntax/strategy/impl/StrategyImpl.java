package com.basesyntax.strategy.impl;

import com.basesyntax.strategy.OperationHandler;
import com.basesyntax.strategy.Strategy;
import java.util.HashMap;
import java.util.Map;

public class StrategyImpl implements Strategy {
    private final Map<String, OperationHandler> strategyMap = new HashMap<>();

    @Override
    public void addStrategyType(String operationType, OperationHandler operationHandler) {
        strategyMap.put(operationType, operationHandler);
    }

    @Override
    public OperationHandler getStrategyType(String type) {
        return strategyMap.get(type);
    }
}
