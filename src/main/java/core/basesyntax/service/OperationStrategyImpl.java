package core.basesyntax.service;

import core.basesyntax.service.operationhandler.OperationHandler;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private Map<String, OperationHandler> operationHandlerMap;

    public OperationStrategyImpl(Map<String, OperationHandler> operationHandlerMap) {
        this.operationHandlerMap = operationHandlerMap;
    }

    @Override
    public OperationHandler getOperationHandler(String operation) {
        return operationHandlerMap.get(operation);
    }

}
