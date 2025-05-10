package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.handler.TransactionHandler;

public interface TransactionStrategy {
    TransactionHandler get(FruitTransaction.Operation operation);
}
