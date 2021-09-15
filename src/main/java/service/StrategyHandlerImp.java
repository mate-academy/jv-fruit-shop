package service;

import java.util.Map;
import service.activities.Activities;

public class StrategyHandlerImp implements StrategyHandler {
    private final Map<String, Activities> activitiesHandlerMap;

    public StrategyHandlerImp(Map<String, Activities> activitiesHandlerMap) {
        this.activitiesHandlerMap = activitiesHandlerMap;
    }

    @Override
    public Activities get(String activityType) {
        return activitiesHandlerMap.get(activityType);
    }
}
