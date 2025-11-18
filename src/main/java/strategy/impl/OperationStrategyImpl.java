package strategy.impl;

import java.util.Map;
import model.FruitTransaction;
import strategy.OperationHandler;
import strategy.OperationStrategy;

public class OperationStrategyImpl implements OperationStrategy {
    private final Map<FruitTransaction.Operation, OperationHandler> operationHandlers;

    public OperationStrategyImpl(Map<FruitTransaction.Operation,
            OperationHandler> operationHandlers) {
        if (operationHandlers == null) {
            throw new NullPointerException("The Map " + operationHandlers
                    + "is null. Can't be assigned as a field.");
        }
        this.operationHandlers = operationHandlers;
    }

    @Override
    public OperationHandler get(FruitTransaction.Operation operation) {
        OperationHandler operationType = operationHandlers.get(operation);
        if (operationType != null) {
            return operationType;
        }
        throw new RuntimeException("Unknown type of operation: " + operation);
    }
}
