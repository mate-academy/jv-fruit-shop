package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.strategy.TransactionHandler;

public interface TransactionStrategy {
    TransactionHandler getTransaction(FruitTransaction.Operation operation);
}
