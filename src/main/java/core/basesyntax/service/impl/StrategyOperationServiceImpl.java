package core.basesyntax.service.impl;

import core.basesyntax.model.OperationType;
import core.basesyntax.service.StrategyOperationService;
import core.basesyntax.strategy.OperationHandler;
import exception.OperationException;
import java.util.Map;

public class StrategyOperationServiceImpl implements StrategyOperationService {
    private Map<OperationType, OperationHandler> operationHandlerMap;

    public StrategyOperationServiceImpl(Map<OperationType, OperationHandler> operationHandlerMap) {
        this.operationHandlerMap = operationHandlerMap;
    }

    @Override
    public OperationHandler get(OperationType operationType) {
        OperationHandler handler = operationHandlerMap.get(operationType);
        if (handler != null) {
            return handler;
        }
        throw new OperationException("Operation type is not correct: " + operationType);
    }
}
