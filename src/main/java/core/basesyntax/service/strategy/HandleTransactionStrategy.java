package core.basesyntax.service.strategy;

import core.basesyntax.model.FruitTransaction;

public interface HandleTransactionStrategy {
    TransactionHandler get(FruitTransaction.Operation type);
}
