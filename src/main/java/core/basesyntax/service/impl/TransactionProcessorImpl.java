package core.basesyntax.service.impl;

import core.basesyntax.dto.Operation;
import core.basesyntax.dto.ProductTransaction;
import core.basesyntax.service.TransactionProcessor;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import core.basesyntax.strategy.handler.OperationHandler;
import java.util.List;
import java.util.Map;

public class TransactionProcessorImpl implements TransactionProcessor {
    private final Map<Operation, OperationHandler> operationHandlers;

    public TransactionProcessorImpl(
            Map<Operation, OperationHandler> operationHandlers) {
        this.operationHandlers = operationHandlers;
    }

    @Override
    public void process(List<ProductTransaction> productTransactions) {
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlers);
        OperationHandler operationHandler;
        for (var transaction : productTransactions) {
            operationHandler = operationStrategy.findHandler(transaction.operation());
            operationHandler.handle(transaction);
        }
    }
}
