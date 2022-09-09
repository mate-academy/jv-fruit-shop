package core.basesyntax.strategy;

import core.basesyntax.model.Transaction;

public interface TransactionsHandling {
    void applyTransaction(Transaction transaction);
}
