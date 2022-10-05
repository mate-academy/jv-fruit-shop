package core.basesyntax.strategy;

import core.basesyntax.service.OperationHandler;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private final Map<String, OperationHandler> handlersMap;

    public OperationStrategyImpl(Map<String, OperationHandler> handlersMap) {
        this.handlersMap = handlersMap;
    }

    @Override
    public OperationHandler get(String operation) {
        return handlersMap.get(operation);
    }
}
