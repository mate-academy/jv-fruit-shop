package core.basesyntax.services;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.services.transaction.Transaction;

public interface TransactionStrategy {
    Transaction get(FruitTransaction.Operation operation);
}
