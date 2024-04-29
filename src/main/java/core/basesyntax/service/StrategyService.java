package core.basesyntax.service;

import core.basesyntax.strategy.StrategyHandler;

public interface StrategyService {
    StrategyHandler getStrategy(String typeStrategy);
}
