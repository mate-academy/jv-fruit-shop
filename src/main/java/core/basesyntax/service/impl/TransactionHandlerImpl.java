package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.TransactionHandler;
import core.basesyntax.strategy.OperationStrategy;
import java.util.List;

public class TransactionHandlerImpl implements TransactionHandler {
    private final OperationStrategy strategy;

    public TransactionHandlerImpl(OperationStrategy strategy) {
        this.strategy = strategy;
    }

    public void handleTransactions(List<FruitTransaction> transactionList) {
        transactionList.forEach(transaction ->
                strategy.getOperationHandler(transaction.getOperation())
                        .handleOperation(transaction));
    }
}
