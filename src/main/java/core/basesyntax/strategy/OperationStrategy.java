package core.basesyntax.strategy;

import core.basesyntax.model.Transaction;
import java.util.Map;

public class OperationStrategy {
    private Map<Transaction.Operation, OperationHandler> operationHandlerMap;

    public OperationStrategy(Map<Transaction.Operation, OperationHandler> operationHandlerMap) {
        this.operationHandlerMap = operationHandlerMap;
    }

    public OperationHandler getHandlerByOperation(Transaction.Operation operation) {
        return operationHandlerMap.get(operation);
    }
}
