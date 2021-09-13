package shop.service;

import java.util.Map;
import shop.service.operations.Operation;

public class OperationsStrategyImpl implements OperationsStrategy {
    private Map<String, Operation> operationMap;

    public OperationsStrategyImpl(Map<String, Operation> operationMap) {
        this.operationMap = operationMap;
    }

    @Override
    public Operation get(String operationIndex) {
        return operationMap.get(operationIndex);
    }
}
