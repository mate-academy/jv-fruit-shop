package core.basesyntax.service;

import core.basesyntax.strategy.TransactionStrategy;

public interface ProcessDataService {
    void processTransactions(TransactionStrategy transactionStrategy);
}
