package core.basesyntax.service.fileoperation.impl;

import core.basesyntax.model.Transaction;
import core.basesyntax.service.fileoperation.TransactionProcessing;
import core.basesyntax.strategy.StrategyOperation;
import java.util.List;

public class TransactionProcessingImpl implements TransactionProcessing {
    private final StrategyOperation strategyOperation;

    public TransactionProcessingImpl(StrategyOperation strategyOperation) {
        this.strategyOperation = strategyOperation;
    }

    @Override
    public void transactionProcessing(List<Transaction> transactions) {
        for (Transaction transaction : transactions) {
            strategyOperation.getOperationHandler(transaction.getType()).operation(transaction);
        }
    }
}
