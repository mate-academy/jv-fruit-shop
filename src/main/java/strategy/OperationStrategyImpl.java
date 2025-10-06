package strategy;

import java.util.HashMap;
import java.util.Map;
import model.FruitTransaction;

public class OperationStrategyImpl implements OperationStrategy {

    private final Map<FruitTransaction.Operation, OperationHandler> handlers;

    public OperationStrategyImpl(Map<FruitTransaction.Operation, OperationHandler> handlers) {
        if (handlers == null) {
            throw new IllegalArgumentException("Handlers null");
        }
        this.handlers = new HashMap<>(handlers);
    }

    @Override
    public OperationHandler getHandler(FruitTransaction.Operation operation) {
        if (operation == null) {
            throw new IllegalArgumentException("Operation null");
        }

        OperationHandler handler = handlers.get(operation);
        if (handler == null) {
            throw new IllegalArgumentException("No handler for: " + operation);
        }

        return handler;
    }
}
