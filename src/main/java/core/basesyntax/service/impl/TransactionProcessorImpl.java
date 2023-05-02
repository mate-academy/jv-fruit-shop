package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.TransactionProcessor;
import core.basesyntax.strategy.OperationHandlerStrategy;
import java.util.List;

public class TransactionProcessorImpl implements TransactionProcessor {
    private OperationHandlerStrategy strategy;

    public TransactionProcessorImpl(OperationHandlerStrategy strategy) {
        this.strategy = strategy;
    }

    @Override
    public void processData(List<FruitTransaction> dataOfTransaction) {
        for (FruitTransaction transaction : dataOfTransaction) {
            strategy.getOperation(transaction.getOperation())
                    .operate(transaction.getFruit(), transaction.getQuantity());
        }
    }
}
