package fruitshop.strategy.operation.impl;

import fruitshop.model.Operation;
import fruitshop.strategy.operation.OperationHandler;
import fruitshop.strategy.operation.OperationStrategy;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private final Map<Operation, ? super OperationHandler> handlers;

    public OperationStrategyImpl(Map<Operation, ? super OperationHandler> handlers) {
        this.handlers = handlers;
    }

    public OperationHandler getHandler(Operation operation) {
        return (OperationHandler) handlers.get(operation);
    }
}
