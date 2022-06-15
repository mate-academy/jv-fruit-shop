package core.basesyntax.strategy;

import core.basesyntax.service.transaction.TransactionHandler;

public interface TransactionsStrategy {
    TransactionHandler get(String dataFromFile);
}
