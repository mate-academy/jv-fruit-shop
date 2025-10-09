package strategy;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import model.FruitTransaction;

public class OperationStrategyImpl implements OperationStrategy {
    private final Map<FruitTransaction.Operation, OperationHandler> handlers;

    public OperationStrategyImpl(Map<FruitTransaction.Operation, OperationHandler> handlers) {
        this.handlers = new HashMap<>(handlers);
    }

    @Override
    public OperationHandler getHandler(FruitTransaction.Operation operation) {
        return handlers.get(operation);
    }

    public Map<FruitTransaction.Operation, OperationHandler> getHandlers() {
        return Collections.unmodifiableMap(handlers);
    }
}
