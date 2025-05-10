package core.basesyntax.service;

import core.basesyntax.model.Transaction;

public interface TransactionProcessor<T extends Transaction> {
    void process(T transaction);
}
