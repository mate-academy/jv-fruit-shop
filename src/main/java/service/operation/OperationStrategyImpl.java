package service.operation;

import java.util.Map;
import model.Transaction;

public class OperationStrategyImpl implements OperationStrategy {
    private final Map<Transaction.Operation, OperationHandler> operationsMap;

    public OperationStrategyImpl(Map<Transaction.Operation, OperationHandler> operationsMap) {
        this.operationsMap = operationsMap;
    }

    @Override
    public OperationHandler getOperation(Transaction transaction) {
        return operationsMap.get(transaction.getOperation());
    }
}
