package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.TransactionStrategy;

public interface StrategyService {
    TransactionStrategy getTransactionStrategy(FruitTransaction transaction);
}
