package core.basesyntax.strategy;

import core.basesyntax.model.Transaction;

public interface TransactionsHandler {
    void applyTransaction(Transaction transaction);
}
