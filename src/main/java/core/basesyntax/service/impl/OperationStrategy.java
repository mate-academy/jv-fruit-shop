package core.basesyntax.service.impl;

import core.basesyntax.service.Strategy;
import core.basesyntax.strategy.OperationHandler;
import java.util.Map;

public class OperationStrategy implements Strategy {
    private Map<String, OperationHandler> handlers;

    public OperationStrategy(Map<String, OperationHandler> handlers) {
        this.handlers = handlers;
    }

    @Override
    public OperationHandler get(String line) {
        return handlers.get(line);
    }
}
