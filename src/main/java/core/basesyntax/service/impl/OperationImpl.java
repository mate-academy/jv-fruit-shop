package core.basesyntax.service.impl;

import core.basesyntax.model.OperationWithFruit;
import core.basesyntax.strategy.Operation;
import java.util.Map;

public class OperationImpl implements core.basesyntax.service.Operation {
    private final Map<OperationWithFruit, Operation> handlerMap;

    public OperationImpl(Map<OperationWithFruit, Operation> openFilesHandlerMap) {
        this.handlerMap = openFilesHandlerMap;
    }

    @Override
    public Operation getOperationHandler(OperationWithFruit operation) {
        return handlerMap.get(operation);
    }
}
