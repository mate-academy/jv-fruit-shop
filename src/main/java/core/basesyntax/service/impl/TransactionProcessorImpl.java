package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.TransactionProcessor;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.impl.OperationStrategyImpl;
import java.util.List;

public class TransactionProcessorImpl implements TransactionProcessor {
    private final OperationStrategy operationStrategy = new OperationStrategyImpl();

    @Override
    public void process(List<FruitTransaction> transactions) {
        transactions.forEach(transaction -> operationStrategy
                .getHandlerByOperation(transaction.getOperation()).apply(transaction));
    }
}
