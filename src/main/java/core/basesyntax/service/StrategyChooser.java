package core.basesyntax.service;

import core.basesyntax.strategy.Strategy;

public interface StrategyChooser {
    Strategy getStrategy(String[] line);
}
