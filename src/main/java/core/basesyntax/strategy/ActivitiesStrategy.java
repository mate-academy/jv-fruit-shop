package core.basesyntax.strategy;

import core.basesyntax.service.activitiy.ActivityHandler;
import core.basesyntax.service.activitiy.ActivityType;

public interface ActivitiesStrategy {
    ActivityHandler get(ActivityType activityType);
}
