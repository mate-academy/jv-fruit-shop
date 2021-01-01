package core.basesyntax.service;

import core.basesyntax.service.operation.OperationHandler;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private Map<String, OperationHandler> operationHandlerMap;

    public OperationStrategyImpl(Map<String, OperationHandler> operationHandlerMap) {
        this.operationHandlerMap = operationHandlerMap;
    }

    @Override
    public List<String> getListOfOperations() {
        return new ArrayList<>(operationHandlerMap.keySet());
    }

    @Override
    public OperationHandler get(String operation) {
        return operationHandlerMap.get(operation);
    }
}
