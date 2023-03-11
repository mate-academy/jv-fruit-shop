package strategy;

import strategy.activity.ActivityHandler;

public interface ActivityStrategy {
    ActivityHandler get(String activityType);
}
