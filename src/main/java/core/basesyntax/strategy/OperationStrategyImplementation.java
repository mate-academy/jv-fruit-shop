package core.basesyntax.strategy;

import core.basesyntax.service.operationHandler.OperationHandler;

import java.util.Map;

public class OperationStrategyImplementation implements OperationStrategy{
    private Map<String, OperationHandler> operationHandlerMap;

    public OperationStrategyImplementation(Map<String, OperationHandler> operationHandlerMap) {
        this.operationHandlerMap = operationHandlerMap;
    }

    @Override
    public OperationHandler get(String operationType) {
        return operationHandlerMap.get(operationType);
    }
}
