package core.basesyntax.strategy;

import core.basesyntax.models.Transaction;

public interface TransactionHandler {
    boolean handleTransaction(Transaction transaction);
}
