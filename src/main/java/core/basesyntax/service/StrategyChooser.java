package core.basesyntax.service;

import core.basesyntax.strategу.Strategy;

public interface StrategyChooser {
    Strategy getStrategy(String[] line);
}
