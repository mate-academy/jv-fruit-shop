package core.basesyntax.service.strategy;

import core.basesyntax.model.FruitTransaction;

public interface ActivitiesStrategy {
    ActivitiesHandler get(FruitTransaction.Operation operation);
}
