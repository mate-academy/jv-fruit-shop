package strategy;

import interfaces.OperationHandler;
import interfaces.OperationStrategy;
import java.util.Map;
import service.impl.FruitTransaction;

public class OperationStrategyImpl implements OperationStrategy {
    private final Map<FruitTransaction.Operation,
            OperationHandler> handlers;

    public OperationStrategyImpl(Map<FruitTransaction.Operation,
            OperationHandler> handlers) {
        this.handlers = handlers;
    }

    @Override
    public OperationHandler get(FruitTransaction.Operation op) {
        if (handlers.get(op) == null) {
            throw new IllegalArgumentException(String.format("Operation %s not found", op));
        }
        return handlers.get(op);
    }
}
