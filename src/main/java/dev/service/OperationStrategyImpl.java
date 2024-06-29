package dev.service;

import dev.service.operation.OperationHandler;
import dev.transaction.FruitTransaction;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private Map<FruitTransaction.Operation, OperationHandler> operationHandlers;

    public OperationStrategyImpl(
            Map<FruitTransaction.Operation, OperationHandler> operationHandlers) {
        this.operationHandlers = operationHandlers;
    }

    public OperationHandler toOperationHandler(FruitTransaction.Operation operation) {
        return operationHandlers.get(operation);
    }
}
