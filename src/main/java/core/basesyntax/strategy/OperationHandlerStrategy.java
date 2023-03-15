package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.impl.DefaultOperationHandler;
import java.util.Map;

public class OperationHandlerStrategy {
    private final Map<String, OperationHandler> handlers;
    private final DefaultOperationHandler defaultHandler;

    public OperationHandlerStrategy(Map<String, OperationHandler> handlers,
                                    DefaultOperationHandler defaultHandler) {
        this.handlers = handlers;
        this.defaultHandler = defaultHandler;
    }

    public OperationHandler getHandler(FruitTransaction.Operation operation) {
        for (Map.Entry<String, OperationHandler> entry : handlers.entrySet()) {
            if (entry.getKey().equals(operation.name())) {
                return entry.getValue();
            }
        }
        return defaultHandler;
    }
}
