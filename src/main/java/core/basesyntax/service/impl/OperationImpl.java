package core.basesyntax.service.impl;

import core.basesyntax.model.OperationWithFruit;
import core.basesyntax.service.Operation;
import core.basesyntax.strategy.OperationHandler;
import java.util.Map;

public class OperationImpl implements Operation {
    private final Map<OperationWithFruit, OperationHandler> handlerMap;

    public OperationImpl(Map<OperationWithFruit, OperationHandler> handlerMap) {
        this.handlerMap = handlerMap;
    }

    @Override
    public OperationHandler getOperationHandler(OperationWithFruit operation) {
        return handlerMap.get(operation);
    }
}
