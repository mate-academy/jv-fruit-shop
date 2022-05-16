package mate.academy.strategy.impl;

import java.util.Map;
import mate.academy.model.Fruit;
import mate.academy.operation.OperationHandler;
import mate.academy.strategy.OperationStrategy;

public class OperationStrategyImpl implements OperationStrategy {
    private final Map<Fruit.Operation, OperationHandler> operationHandlerMap;

    public OperationStrategyImpl(Map<Fruit.Operation,
            OperationHandler> operationHandlerMap) {
        this.operationHandlerMap = operationHandlerMap;
    }

    @Override
    public OperationHandler get(Fruit.Operation operation) {
        return operationHandlerMap.get(operation);
    }
}
