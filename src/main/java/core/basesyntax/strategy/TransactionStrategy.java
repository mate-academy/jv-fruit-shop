package core.basesyntax.strategy;

import core.basesyntax.strategy.transaction.FruitTransaction;
import core.basesyntax.strategy.transaction.TransactionHandler;

public interface TransactionStrategy {
    TransactionHandler get(FruitTransaction.Operation operation);
}
