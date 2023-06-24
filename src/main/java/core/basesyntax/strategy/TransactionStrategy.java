package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import java.util.Map;

public class TransactionStrategy {
    private Map<FruitTransaction.Operation, OperationHandler> operationHandlers;

    public TransactionStrategy(Map<FruitTransaction.Operation,
            OperationHandler> operationHandlers) {
        this.operationHandlers = operationHandlers;
    }

    public OperationHandler getTransactionService(FruitTransaction.Operation operation) {
        return operationHandlers.get(operation);
    }

}
