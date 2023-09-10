package core.basesyntax.strategy.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.HandlerStrategy;
import core.basesyntax.strategy.OperationHandler;
import java.util.Map;

public class HandlerStrategyImpl implements HandlerStrategy {
    private final Map<FruitTransaction.Operation, OperationHandler> operationHandlerMap;

    public HandlerStrategyImpl(Map<FruitTransaction.Operation, OperationHandler> handlerMap) {
        this.operationHandlerMap = handlerMap;
    }

    @Override
    public OperationHandler get(FruitTransaction.Operation operation) {
        return operationHandlerMap.get(operation);
    }
}
