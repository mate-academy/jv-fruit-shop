package core.basesyntax.strategy;

import core.basesyntax.service.activity.ActivityHandler;

public interface ActivityStrategy {
    ActivityHandler get(String activityType);
}
