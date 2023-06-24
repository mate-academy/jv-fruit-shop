package strategy;

import java.util.Map;
import strategy.activities.ActivitiesHandler;

public class ActivitiesStrategyImpl implements ActivitiesStrategy {
    private Map<String, ActivitiesHandler> activitiesHandlerMap;

    public ActivitiesStrategyImpl(Map<String, ActivitiesHandler> activitiesHandlerMap) {
        this.activitiesHandlerMap = activitiesHandlerMap;
    }

    @Override
    public ActivitiesHandler get(String firstChar) {
        return activitiesHandlerMap.get(firstChar);
    }
}
