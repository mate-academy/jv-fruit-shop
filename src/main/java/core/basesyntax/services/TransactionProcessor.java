package core.basesyntax.services;

import core.basesyntax.models.FruitTransaction;
import java.util.List;
import java.util.Map;

public class TransactionProcessor {
    private final Map<FruitTransaction.Operation, OperationHandler> operationHandlers;

    public TransactionProcessor(Map<FruitTransaction.Operation,
            OperationHandler> operationHandlers) {
        this.operationHandlers = operationHandlers;
    }

    public void processTransactions(List<FruitTransaction> transactions) {
        for (FruitTransaction transaction : transactions) {
            OperationHandler handler = operationHandlers.get(transaction.getOperation());
            if (handler != null) {
                handler.apply(transaction);
            } else {
                throw new IllegalArgumentException("Unknown operation: "
                        + transaction.getOperation());
            }
        }
    }
}
