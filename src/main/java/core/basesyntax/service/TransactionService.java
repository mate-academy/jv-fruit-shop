package core.basesyntax.service;

import core.basesyntax.model.Transaction;

public interface TransactionService {
    void apply(Transaction transaction);
}
