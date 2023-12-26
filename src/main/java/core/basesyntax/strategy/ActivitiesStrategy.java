package core.basesyntax.strategy;

import core.basesyntax.constants.Activities;
import core.basesyntax.strategy.handlers.ActivitiesHandler;

public interface ActivitiesStrategy {
    public ActivitiesHandler get(Activities activity);
}
