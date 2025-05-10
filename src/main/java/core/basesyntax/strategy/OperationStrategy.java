package core.basesyntax.strategy;

import core.basesyntax.model.Operation;
import core.basesyntax.service.TransactionHandler;
import java.util.Map;

public class OperationStrategy {
    private Map<String, TransactionHandler> operationMap;

    public OperationStrategy(Map<String, TransactionHandler> operationMap) {
        this.operationMap = operationMap;
    }

    public TransactionHandler getOperationHandler(Operation operation) {
        TransactionHandler transactionHandler = operationMap.get(operation.getCode());
        if (transactionHandler == null) {
            throw new RuntimeException("This operation doesn't exist " + operation);
        }
        return transactionHandler;
    }
}
