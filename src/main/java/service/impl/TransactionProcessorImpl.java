package service.impl;

import model.FruitTransaction;
import operation.OperationStrategy;
import service.TransactionProcessor;

public class TransactionProcessorImpl implements TransactionProcessor {
    private final OperationStrategy operationStrategy;

    public TransactionProcessorImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    public void process(FruitTransaction fruitTransaction) {
        operationStrategy.get(fruitTransaction.operation()).accept(fruitTransaction);
    }
}
