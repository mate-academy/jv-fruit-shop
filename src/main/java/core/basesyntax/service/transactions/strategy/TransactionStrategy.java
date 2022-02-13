package core.basesyntax.service.transactions.strategy;

import core.basesyntax.model.Transaction;
import core.basesyntax.service.transactions.TransactionHandler;

public interface TransactionStrategy {
    TransactionHandler getTransactionHandler(Transaction.TransactionType transactionType);
}
