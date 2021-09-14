package shop.service;

import java.util.Map;
import shop.service.operations.OperationHandler;

public class OperationsStrategyImpl implements OperationsStrategy {
    private Map<String, OperationHandler> operationMap;

    public OperationsStrategyImpl(Map<String, OperationHandler> operationMap) {
        this.operationMap = operationMap;
    }

    @Override
    public OperationHandler get(String operation) {
        return operationMap.get(operation);
    }
}
