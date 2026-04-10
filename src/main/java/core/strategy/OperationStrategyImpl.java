package core.strategy;

import core.model.Transaction;
import core.strategy.handler.OperationHandler;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private final Map<Transaction.Operation, OperationHandler> handlers;
    
    public OperationStrategyImpl(Map<Transaction.Operation, OperationHandler> handlers) {
        this.handlers = handlers;
    }

    @Override
    public OperationHandler getOperationHandler(Transaction.Operation operation) {
        if (handlers == null || handlers.isEmpty()) {
            throw new RuntimeException("No operation handler for operation: " + operation);
        }
        return handlers.get(operation);
    }
}
