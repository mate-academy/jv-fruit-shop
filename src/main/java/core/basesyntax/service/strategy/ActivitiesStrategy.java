package core.basesyntax.service.strategy;

import core.basesyntax.model.Activities;

public interface ActivitiesStrategy {
    ActivitiesHandler get(Activities activities);
}
