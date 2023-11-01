package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.HandlerStrategy;

public interface TransactionProcessor {
    public void processTransaction(FruitTransaction transaction, HandlerStrategy handlerStrategy);
}
