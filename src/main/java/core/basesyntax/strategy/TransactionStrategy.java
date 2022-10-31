package core.basesyntax.strategy;

import core.basesyntax.strategy.handlers.TransactionHandler;
import core.basesyntax.model.FruitTransaction;

public interface TransactionStrategy {
    TransactionHandler get(FruitTransaction.Operation operation);
}
