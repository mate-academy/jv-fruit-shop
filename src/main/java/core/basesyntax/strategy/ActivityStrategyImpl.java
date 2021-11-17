package core.basesyntax.strategy;

import core.basesyntax.strategy.activity.ActivityHandler;
import java.util.Map;

public class ActivityStrategyImpl implements ActivityStrategy {
    private final Map<String, ActivityHandler> handlerMap;

    public ActivityStrategyImpl(Map<String, ActivityHandler> handlerMap) {
        this.handlerMap = handlerMap;
    }

    @Override
    public ActivityHandler get(String operation) {
        return handlerMap.get(operation);
    }
}
