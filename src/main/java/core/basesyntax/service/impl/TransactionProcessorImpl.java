package core.basesyntax.service.impl;

import core.basesyntax.dto.Transaction;
import core.basesyntax.service.TransactionProcessor;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import core.basesyntax.strategy.handler.OperationHandler;
import java.util.List;
import java.util.Map;

public class TransactionProcessorImpl implements TransactionProcessor {
    private final Map<Transaction.Operation, OperationHandler> operationHandlers;

    public TransactionProcessorImpl(
            Map<Transaction.Operation, OperationHandler> operationHandlers) {
        this.operationHandlers = operationHandlers;
    }

    @Override
    public void process(List<Transaction> transactions) {
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlers);
        OperationHandler operationHandler;
        for (var transaction : transactions) {
            operationHandler = operationStrategy.findHandler(transaction.operation());
            operationHandler.handle(transaction);
        }
    }
}
