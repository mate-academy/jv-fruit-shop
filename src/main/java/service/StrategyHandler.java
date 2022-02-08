package service;

import service.activities.Activities;

public interface StrategyHandler {
    public Activities get(String activityType);
}
