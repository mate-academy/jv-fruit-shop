package core.basesyntax.strategy;

import core.basesyntax.constants.Activity;
import core.basesyntax.strategy.handlers.ActivityHandler;
import java.util.Map;

public class ActivitiesStrategyImpl implements ActivitiesStrategy {
    private final Map<Activity, ActivityHandler> strategyMap;

    public ActivitiesStrategyImpl(Map<Activity, ActivityHandler> strategyMap) {
        this.strategyMap = strategyMap;
    }

    @Override
    public ActivityHandler get(Activity activity) {
        return strategyMap.get(activity);
    }
}
