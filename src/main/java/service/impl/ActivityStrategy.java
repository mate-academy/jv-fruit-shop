package service.impl;

import service.impl.activity.ActivityHandler;

public interface ActivityStrategy {
    ActivityHandler select(String activityType);
}
