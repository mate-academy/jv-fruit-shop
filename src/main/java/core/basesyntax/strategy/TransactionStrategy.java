package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.transaction.TransactionHandler;

public interface TransactionStrategy {
    TransactionHandler getHandler(FruitTransaction.Operation operation);
}
