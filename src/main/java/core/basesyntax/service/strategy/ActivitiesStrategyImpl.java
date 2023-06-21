package core.basesyntax.service.strategy;

import core.basesyntax.model.Activities;
import java.util.Map;

public class ActivitiesStrategyImpl implements ActivitiesStrategy {
    private final Map<Activities, ActivitiesHandler> activitiesHandlerMap;

    public ActivitiesStrategyImpl(Map<Activities, ActivitiesHandler>
                                          activitiesHandlerMap) {
        this.activitiesHandlerMap = activitiesHandlerMap;
    }

    @Override
    public ActivitiesHandler get(Activities activities) {
        return activitiesHandlerMap.get(activities);
    }
}
