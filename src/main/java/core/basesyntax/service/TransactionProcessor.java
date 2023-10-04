package core.basesyntax.service;

import core.basesyntax.model.Transaction;

public interface TransactionProcessor {
    void process(Transaction transaction);
}
