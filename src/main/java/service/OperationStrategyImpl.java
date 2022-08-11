package service;

import service.operation.Operation;

import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private Map<ProductTransaction.Operation, Operation> operationMap;

    public OperationStrategyImpl(Map<ProductTransaction.Operation, Operation> operationMap) {
        this.operationMap = operationMap;
    }

    @Override
    public Operation get(ProductTransaction.Operation operation) {
        return operationMap.get(operation);
    }
}
