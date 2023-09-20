package core.basesyntax.operation;

import core.basesyntax.FruitTransaction;

public interface TransactionHandlerStrategy {
    TransactionHandler get(FruitTransaction.Operation operation);
}
