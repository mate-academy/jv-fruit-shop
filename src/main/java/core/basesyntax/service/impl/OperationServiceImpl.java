package core.basesyntax.service.impl;

import core.basesyntax.model.Operation;
import core.basesyntax.service.OperationService;
import core.basesyntax.strategy.OperationHandler;
import java.util.Map;

public class OperationServiceImpl implements OperationService {
    private final Map<Operation, OperationHandler> handleMap;

    public OperationServiceImpl(Map<Operation, OperationHandler> handleMap) {
        this.handleMap = handleMap;
    }

    @Override
    public OperationHandler getHandler(Operation typeOperation) {
        return handleMap.get(typeOperation);
    }
}
