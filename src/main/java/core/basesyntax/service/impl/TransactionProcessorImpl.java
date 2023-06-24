package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.TransactionProcessor;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.impl.OperationStrategyImpl;
import java.util.List;
import java.util.Map;

public class TransactionProcessorImpl implements TransactionProcessor {
    private OperationStrategy operationStrategy;

    @Override
    public void process(List<FruitTransaction> transactions,
                        Map<FruitTransaction.Operation, OperationHandler> operationHandlerMap) {
        operationStrategy = new OperationStrategyImpl(operationHandlerMap);
        transactions.forEach(transaction -> operationStrategy
                .getOperationHandler(transaction.getOperation())
                .handle(transaction));
    }
}
