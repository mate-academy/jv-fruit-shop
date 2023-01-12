package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.TransactionProcessor;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.impl.OperationStrategyImpl;
import java.util.List;

public class TransactionProcessorImpl implements TransactionProcessor {
    private OperationStrategy operationStrategy;

    @Override
    public void process(List<FruitTransaction> transactions) {
        operationStrategy = new OperationStrategyImpl();
        transactions.forEach(transaction -> operationStrategy
                .getOperationHandler(transaction.getOperation())
                .handle(transaction));
    }
}
