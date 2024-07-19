package core.basesyntax.service;

import core.basesyntax.domain.Fruit;
import core.basesyntax.service.operation.OperationHandler;

import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private final Map<Fruit.Operation, OperationHandler> operationHandlerMap;

    public OperationStrategyImpl(Map<Fruit.Operation, OperationHandler> operationHandlerMap) {
        this.operationHandlerMap = operationHandlerMap;
    }

    @Override
    public OperationHandler get(Fruit.Operation operation) {
        return operationHandlerMap.get(operation);
    }
}
