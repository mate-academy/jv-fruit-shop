package core.basesyntax.startegy;

import core.basesyntax.activities.ActivitiesHandler;
import core.basesyntax.activities.ActivityType;

public interface ActivitiesStrategy {
    ActivitiesHandler get(ActivityType type);
}
