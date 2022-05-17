package mate.academy.strategy.impl;

import java.util.Map;
import mate.academy.model.FruitTransaction;
import mate.academy.operation.OperationHandler;
import mate.academy.strategy.OperationStrategy;

public class OperationStrategyImpl implements OperationStrategy {
    private final Map<FruitTransaction.Operation, OperationHandler> operationHandlerMap;

    public OperationStrategyImpl(Map<FruitTransaction.Operation,
            OperationHandler> operationHandlerMap) {
        this.operationHandlerMap = operationHandlerMap;
    }

    @Override
    public OperationHandler process(FruitTransaction.Operation operation) {
        return operationHandlerMap.get(operation);
    }
}
