package core.basesyntax.service.impl;

import core.basesyntax.model.Operation;
import core.basesyntax.operations.OperationHandler;
import core.basesyntax.service.StrategyService;
import java.util.Map;

public class StrategyServiceImpl implements StrategyService {
    private Map<Operation, OperationHandler> operationHandlerMap;

    public StrategyServiceImpl(Map<Operation, OperationHandler> operationHandlerMap) {
        this.operationHandlerMap = operationHandlerMap;
    }

    @Override
    public OperationHandler getHandler(Operation operation) {
        return operationHandlerMap.get(operation);
    }
}
