package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.handler.TransactionHandler;

public interface Strategy {
    TransactionHandler get(FruitTransaction.Operation key);
}
