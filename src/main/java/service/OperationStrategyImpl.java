package service;

import java.util.Map;
import model.FruitTransaction;
import service.operation.OperationHandler;

public class OperationStrategyImpl implements OperationStrategy {
    private final Map<FruitTransaction.Operation, OperationHandler> operationHandlersMap;

    public OperationStrategyImpl(
            Map<FruitTransaction.Operation, OperationHandler> operationHandlersMap) {
        this.operationHandlersMap = operationHandlersMap;
    }

    @Override
    public OperationHandler get(FruitTransaction.Operation operation) {
        OperationHandler operationHandler = operationHandlersMap.get(operation);

        if (operationHandler == null) {
            throw new RuntimeException("No handler for operation: " + operation);
        }

        return operationHandler;
    }
}
