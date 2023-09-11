package core.basesyntax.strategy.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationHandlerStrategy;
import java.util.Map;

public class OperationHandlerStrategyImpl implements OperationHandlerStrategy {
    private final Map<FruitTransaction.Operation, OperationHandler> operationHandlerMap;

    public OperationHandlerStrategyImpl(Map<FruitTransaction.Operation,
            OperationHandler> handlerMap) {
        this.operationHandlerMap = handlerMap;
    }

    @Override
    public OperationHandler get(FruitTransaction.Operation operation) {
        return operationHandlerMap.get(operation);
    }
}
