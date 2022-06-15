package core.basesyntax.strategy;

import core.basesyntax.strategy.transaction.TransactionHandler;

public interface TransactionStrategy {
    TransactionHandler get(String operation);
}
