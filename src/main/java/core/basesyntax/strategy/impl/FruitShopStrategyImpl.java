package core.basesyntax.strategy.impl;

import core.basesyntax.service.OperationHandler;
import core.basesyntax.strategy.FruitShopStrategy;
import java.util.Map;

public class FruitShopStrategyImpl implements FruitShopStrategy {
    private Map<String, OperationHandler> operationHandlerMap;

    public FruitShopStrategyImpl(Map<String, OperationHandler> operationHandlerMap) {
        this.operationHandlerMap = operationHandlerMap;
    }

    @Override
    public OperationHandler get(String operation) {
        return operationHandlerMap.get(operation);
    }
}
