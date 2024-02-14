package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.TransactionHandler;

public interface TransactionStrategy {
    TransactionHandler getHandler(FruitTransaction transaction);
}
