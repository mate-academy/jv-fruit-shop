package core.basesyntax.services;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.services.transaction.OperationHandler;

public interface TransactionStrategy {
    OperationHandler get(FruitTransaction.Operation operation);
}
