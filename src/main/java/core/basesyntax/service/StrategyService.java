package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.StrategyHandler;

public interface StrategyService {
    StrategyHandler getStrategy(FruitTransaction.Operation operation);
}
