package basesyntax.strategy;

import basesyntax.model.FruitTransaction;
import basesyntax.service.OperationHandler;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {

    private final Map<FruitTransaction.Operation, OperationHandler> handlers;

    public OperationStrategyImpl(
            Map<FruitTransaction.Operation, OperationHandler> handlers) {
        if (handlers == null) {
            throw new IllegalArgumentException("Handlers map cannot be null");
        }
        this.handlers = handlers;
    }

    @Override
    public OperationHandler getHandler(FruitTransaction.Operation operation) {
        OperationHandler handler = handlers.get(operation);
        if (handler == null) {
            throw new IllegalStateException(
                    "No handler for operation: " + operation);
        }
        return handler;
    }
}
