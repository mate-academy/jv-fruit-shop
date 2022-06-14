package core.basesyntax.strategy;

import core.basesyntax.model.ProductTransaction;
import core.basesyntax.strategy.activities.ActivitiesHandler;

public interface ActivitiesStrategy {
    ActivitiesHandler get(ProductTransaction.Operation type);
}
