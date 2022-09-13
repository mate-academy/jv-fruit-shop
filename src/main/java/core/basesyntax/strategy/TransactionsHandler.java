package core.basesyntax.strategy;

import core.basesyntax.model.Transaction;

public interface TransactionsHandler {
    void handle(Transaction transaction);
}
