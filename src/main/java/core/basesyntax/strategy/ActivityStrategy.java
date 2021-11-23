package core.basesyntax.strategy;

import core.basesyntax.model.ActivityType;
import core.basesyntax.strategy.activities.ActivityService;

public interface ActivityStrategy {
    ActivityService getActivity(ActivityType activityType);
}
