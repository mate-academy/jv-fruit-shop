package core.strategy;

import core.model.Transaction;
import core.service.handler.OperationHandler;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private final Map<Transaction.Operation, OperationHandler> handlers;
    
    public OperationStrategyImpl(Map<Transaction.Operation, OperationHandler> handlers) {
        this.handlers = handlers;
    }

    public OperationHandler getHandler(Transaction.Operation op) {
        return handlers.get(op);
    }
}
