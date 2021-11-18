package core.basesyntax.strategy;

import core.basesyntax.service.activities.ActivitiesHandler;
import java.util.Map;

public class ActivityStrategyImpl implements ActivityStrategy {
    private Map<String, ActivitiesHandler> activitiesHandlerMap;

    public ActivityStrategyImpl(Map<String, ActivitiesHandler> activitiesHandlerMap) {
        this.activitiesHandlerMap = activitiesHandlerMap;
    }

    @Override
    public ActivitiesHandler get(String reportLine) {
        String letter = reportLine.substring(0, reportLine.indexOf(","));
        return activitiesHandlerMap.get(letter);
    }
}
