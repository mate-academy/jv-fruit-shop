package core.basesyntax.factory;

import core.basesyntax.model.Operation;
import core.basesyntax.strategy.Strategy;

public interface Factory {
    Strategy getStrategy(Operation operation);
}
