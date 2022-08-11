package service;

import java.util.Map;
import service.operation.Operation;

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
