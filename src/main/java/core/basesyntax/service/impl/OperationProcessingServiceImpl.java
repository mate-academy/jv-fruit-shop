package core.basesyntax.service.impl;

import core.basesyntax.model.Transaction;
import core.basesyntax.service.OperationProcessingStrategy;
import core.basesyntax.service.OperationProcessor;
import java.util.List;

public class OperationProcessingServiceImpl implements OperationProcessor {
    private final OperationProcessingStrategy operationProcessingStrategy;

    public OperationProcessingServiceImpl(OperationProcessingStrategy operationProcessingStrategy) {
        this.operationProcessingStrategy = operationProcessingStrategy;
    }

    @Override
    public void process(List<Transaction> transactionList) {
        transactionList.forEach(
                transaction -> operationProcessingStrategy
                        .get(transaction.getTypeOperation())
                        .handle(transaction));
    }
}
