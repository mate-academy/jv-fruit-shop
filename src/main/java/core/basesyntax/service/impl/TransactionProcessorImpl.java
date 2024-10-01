package core.basesyntax.service.impl;

import core.basesyntax.model.Transaction;
import core.basesyntax.service.OperationHandler;
import core.basesyntax.service.TransactionProcessor;
import java.util.List;
import java.util.Map;

public class TransactionProcessorImpl implements TransactionProcessor {
    private final Map<Transaction.Operation, OperationHandler> operationHandlers;

    public TransactionProcessorImpl(Map<Transaction.Operation,
            OperationHandler> operationHandlers) {
        this.operationHandlers = operationHandlers;
    }

    @Override
    public void process(List<Transaction> transactions) {
        for (Transaction transaction : transactions) {
            OperationHandler handler = operationHandlers.get(transaction.getOperation());
            if (handler != null) {
                handler.handle(transaction.getFruit(), transaction.getQuantity());
            } else {
                throw new IllegalArgumentException("No handler found for operation: "
                        + transaction.getOperation());
            }
        }
    }
}
