package core.basesyntax.strategy.impl;

import core.basesyntax.model.Operation;
import core.basesyntax.service.OperationHandler;
import core.basesyntax.strategy.FruitShopStrategy;
import java.util.Map;

public class FruitShopStrategyImpl implements FruitShopStrategy {
    private Map<Operation, OperationHandler> operationHandlerMap;

    public FruitShopStrategyImpl(Map<Operation, OperationHandler> operationHandlerMap) {
        this.operationHandlerMap = operationHandlerMap;
    }

    @Override
    public OperationHandler get(Operation operation) {
        return operationHandlerMap.get(operation);
    }
}
