package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.transactionhandler.TransactionHandler;

public interface TransactionStrategy {
    TransactionHandler get(FruitTransaction.Operation operationType);
}
