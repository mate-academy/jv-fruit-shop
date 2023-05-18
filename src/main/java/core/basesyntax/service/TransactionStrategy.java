package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.transaction.TransactionHandler;

public interface TransactionStrategy {
    TransactionHandler getHandler(FruitTransaction.Operation operation);
}
