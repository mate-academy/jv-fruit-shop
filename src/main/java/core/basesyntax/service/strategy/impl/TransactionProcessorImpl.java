package core.basesyntax.service.strategy.impl;

import core.basesyntax.dto.FruitTransactionDto;
import core.basesyntax.service.operations.OperationHandler;
import core.basesyntax.service.strategy.OperationStrategy;
import core.basesyntax.service.strategy.TransactionProcessor;
import java.util.List;

public class TransactionProcessorImpl implements TransactionProcessor {
    private OperationStrategy operationStrategy;

    public TransactionProcessorImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    public void process(List<FruitTransactionDto> transactions) {
        for (var transaction : transactions) {
            OperationHandler handler = operationStrategy.get(transaction);
            handler.apply(transaction);
        }
    }
}
