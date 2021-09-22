package core.basesyntax.service;

import core.basesyntax.model.ActivitiesType;
import core.basesyntax.service.activityhandler.ActivityHandler;

public interface ActivityTypeStrategy {
    ActivityHandler get(ActivitiesType activitiesType);
}
