package core.basesyntax.service;

import core.basesyntax.model.ActivitiesType;
import core.basesyntax.service.activityhandler.ActivityTypeHandler;

public interface ActivityTypeStrategy {
    ActivityTypeHandler get(ActivitiesType activitiesType);
}
