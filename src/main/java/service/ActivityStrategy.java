package service;

import service.activityhandler.ActivityHandler;

public interface ActivityStrategy {
    ActivityHandler get(String activityType);
}
