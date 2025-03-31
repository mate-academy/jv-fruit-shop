package service.impl;

import java.util.Map;
import model.Transaction;
import service.operation.OperationHandler;
import strategy.OperationStrategy;

public class OperationStrategyImpl implements OperationStrategy {
    private Map<Transaction.Operation, OperationHandler> operationHandlerMap;

    public OperationStrategyImpl(Map<Transaction.Operation, OperationHandler> operationHandlerMap) {
        this.operationHandlerMap = operationHandlerMap;
    }

    @Override
    public OperationHandler get(Transaction.Operation operationType) {
        if (operationHandlerMap.get(operationType) == null) {
            throw new IllegalArgumentException("Cannot retrieve operation handler map by type: "
                    + operationType.getOperationCode());
        }
        return operationHandlerMap.get(operationType);
    }
}
