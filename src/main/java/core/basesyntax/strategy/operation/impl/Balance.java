package core.basesyntax.strategy.operation.impl;

import core.basesyntax.model.Transaction;
import core.basesyntax.strategy.operation.Operation;
import core.basesyntax.strategy.operation.util.TransactionHandler;

public class Balance implements Operation {
    @Override
    public void apply(TransactionHandler transactionHandler, Transaction transaction) {
        transactionHandler.processIncomingTransaction(transaction);
    }
}
