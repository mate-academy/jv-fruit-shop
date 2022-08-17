package services;

import java.util.Map;
import services.operation.OperationHandler;
import services.transaction.model.ProductTransaction;

public class OperationStrategyImpl implements OperationStrategy {
    private Map<ProductTransaction.Operation, OperationHandler> operationMap;

    public OperationStrategyImpl(Map<ProductTransaction.Operation, OperationHandler> operationMap) {
        this.operationMap = operationMap;
    }

    @Override
    public OperationHandler get(ProductTransaction.Operation operation) {
        return operationMap.get(operation);
    }
}
