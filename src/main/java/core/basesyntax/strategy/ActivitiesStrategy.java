package core.basesyntax.strategy;

import core.basesyntax.service.activitiy.ActivityHandler;

public interface ActivitiesStrategy {
    ActivityHandler get(String activityTypeLetter);
}
