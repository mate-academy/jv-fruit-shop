package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitTransactionProcessor;
import core.basesyntax.strategy.OperationStrategy;
import java.util.List;

public class FruitTransactionProcessorImpl implements FruitTransactionProcessor {
    private OperationStrategy operationStrategy;

    public FruitTransactionProcessorImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void process(List<FruitTransaction> transactions) {
        transactions.forEach(transaction ->
                operationStrategy.getOperationType(transaction.getOperation())
                        .handle(transaction));
    }
}
