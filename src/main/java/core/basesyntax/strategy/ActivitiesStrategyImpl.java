package core.basesyntax.strategy;

import core.basesyntax.strategy.handlers.ActivityHandler;
import java.util.Map;

public class ActivitiesStrategyImpl implements ActivitiesStrategy {
    private final Map<String, ActivityHandler> strategyMap;

    public ActivitiesStrategyImpl(Map<String, ActivityHandler> strategyMap) {
        this.strategyMap = strategyMap;
    }

    @Override
    public ActivityHandler get(String activity) {
        return strategyMap.get(activity);
    }
}
