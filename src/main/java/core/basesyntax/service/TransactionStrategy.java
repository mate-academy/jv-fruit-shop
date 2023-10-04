package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.strategy.TransactionHandler;

public interface TransactionStrategy {
    TransactionHandler getHandler(FruitTransaction.Operation operation);
}
