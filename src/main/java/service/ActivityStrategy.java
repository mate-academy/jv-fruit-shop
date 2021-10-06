package service;

import service.activity.ActivityHandler;

public interface ActivityStrategy {
    ActivityHandler select(String activityType);
}
