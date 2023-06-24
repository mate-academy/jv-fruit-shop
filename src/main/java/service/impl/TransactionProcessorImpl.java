package service.impl;

import java.util.List;
import model.FruitTransaction;
import service.TransactionProcessor;
import strategy.OperationStrategy;
import strategy.impl.OperationStrategyImpl;

public class TransactionProcessorImpl implements TransactionProcessor {
    private final OperationStrategy operationStrategy;

    public TransactionProcessorImpl() {
        operationStrategy = new OperationStrategyImpl();
    }

    @Override
    public void process(List<FruitTransaction> transactions) {
        transactions.forEach(
                transaction -> operationStrategy
                .getOperationHandler(transaction.getOperation())
                .apply(transaction)
        );
    }
}
