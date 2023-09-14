package core.basesyntax.strategy;

import core.basesyntax.service.activity.ActivityHandler;
import java.util.Map;

public class ActivityStrategyImpl implements ActivityStrategy {
    private final Map<String, ActivityHandler> handlerMap;

    public ActivityStrategyImpl(Map<String, ActivityHandler> handlerMap) {
        this.handlerMap = handlerMap;
    }

    @Override
    public ActivityHandler get(String activityType) {
        return handlerMap.get(activityType);
    }
}
