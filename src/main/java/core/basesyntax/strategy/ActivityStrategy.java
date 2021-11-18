package core.basesyntax.strategy;

import core.basesyntax.service.activities.ActivitiesHandler;

public interface ActivityStrategy {
    ActivitiesHandler get(String letter);
}
