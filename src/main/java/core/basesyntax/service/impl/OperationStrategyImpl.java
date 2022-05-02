package core.basesyntax.service.impl;

import core.basesyntax.model.LineInformation;
import core.basesyntax.service.OperationStrategy;
import core.basesyntax.service.strategy.OperationHandler;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private final Map<String, OperationHandler> operationHandlerMap;

    public OperationStrategyImpl(Map<String, OperationHandler> operationHandlerMap) {
        this.operationHandlerMap = operationHandlerMap;
    }

    @Override
    public OperationHandler get(LineInformation operation) {
        String operationType = operation.getOperation();
        return operationHandlerMap.get(operationType);
    }
}
