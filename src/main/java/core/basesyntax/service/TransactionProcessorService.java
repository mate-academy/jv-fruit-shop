package core.basesyntax.service;

import core.basesyntax.model.Transaction;

public interface TransactionProcessorService {
    void process(Transaction transaction);
}
