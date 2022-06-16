package core.basesyntax.strategy.activities;

import core.basesyntax.model.ProductTransaction;

public interface ActivitiesHandler {
    void process(ProductTransaction transaction);
}
