package core.basesyntax.service.handler.impl;

import core.basesyntax.model.enums.Operation;
import core.basesyntax.service.handler.OperationHandler;
import core.basesyntax.service.handler.OperationStrategy;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {

    private final Map<Operation, OperationHandler> handlersMap;

    public OperationStrategyImpl(Map<Operation, OperationHandler> handlersMap) {
        this.handlersMap = handlersMap;
    }

    @Override
    public OperationHandler getOperationHandler(Operation operation) {
        return handlersMap.get(operation);
    }
}
