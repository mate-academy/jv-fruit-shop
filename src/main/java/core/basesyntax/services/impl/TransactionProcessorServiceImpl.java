package core.basesyntax.services.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.services.TransactionProcessorService;
import core.basesyntax.strategy.OperationStrategy;
import java.util.List;

public class TransactionProcessorServiceImpl implements TransactionProcessorService {
    private final OperationStrategy operationStrategy;

    public TransactionProcessorServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void processTransactions(List<FruitTransaction> transactions) {
        for (FruitTransaction transaction: transactions) {
            operationStrategy.execute(transaction);
        }
    }
}
