package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.activities.ActivitiesHandler;

public interface ActivitiesStrategy {
    ActivitiesHandler get(FruitTransaction.Operation operation);
}
