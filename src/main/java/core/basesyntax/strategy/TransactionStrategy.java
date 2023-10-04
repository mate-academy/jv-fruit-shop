package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.transaction.TransactionHandler;

public interface TransactionStrategy {
    TransactionHandler get(FruitTransaction.Operation operation);
}
