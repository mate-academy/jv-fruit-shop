package operation.strategy;

import java.util.Map;
import operation.handler.OperationHandler;
import transaction.FruitTransaction;

public class OperationStrategyImpl implements OperationStrategy {
    private final Map<FruitTransaction.Operation, OperationHandler> operationHandlers;

    public OperationStrategyImpl(Map<FruitTransaction.Operation, OperationHandler> operationH) {
        this.operationHandlers = operationH;
    }

    @Override
    public OperationHandler getOperation(FruitTransaction.Operation operation) {
        OperationHandler handler = operationHandlers.get(operation);
        if (handler == null) {
            throw new IllegalArgumentException("No handler found for operation: " + operation);
        }
        return handler;
    }
}
