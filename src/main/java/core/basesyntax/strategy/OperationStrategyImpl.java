package core.basesyntax.strategy;

import core.basesyntax.handler.OperationHandler;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {

    private Map<String, OperationHandler> handlers;

    public OperationStrategyImpl(Map<String, OperationHandler> handlers) {
        this.handlers = handlers;
    }

    @Override
    public OperationHandler get(String operation) {
        return handlers.get(operation);
    }
}
