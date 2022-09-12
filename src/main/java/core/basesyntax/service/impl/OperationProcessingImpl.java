package core.basesyntax.service.impl;

import core.basesyntax.model.Transaction;
import core.basesyntax.service.OperationProcessing;
import core.basesyntax.service.OperationProcessingStrategy;
import java.util.List;

public class OperationProcessingImpl implements OperationProcessing {
    private final OperationProcessingStrategy operationProcessingStrategy;

    public OperationProcessingImpl(OperationProcessingStrategy operationProcessingStrategy) {
        this.operationProcessingStrategy = operationProcessingStrategy;
    }

    @Override
    public void processingData(List<Transaction> transactionList) {
        transactionList.forEach(
                transaction -> operationProcessingStrategy
                        .get(transaction.getTypeOperation())
                        .applyTransaction(transaction));
    }
}
