package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitTransactionProcessor;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationsHandler;
import java.util.List;

public record FruitTransactionProcessorImpl(
        OperationStrategy operationStrategy) implements
        FruitTransactionProcessor {

    public FruitTransactionProcessorImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = (OperationStrategy) operationStrategy;
    }

    @Override
    public void processTransactions(List<FruitTransaction> transactions) {
        transactions.forEach(transaction -> {
            OperationsHandler operationHandler = operationStrategy.getHandler(transaction);
            operationHandler.handle(transaction);
        });
    }

}
