package mate.academy.strategy;

import java.util.Map;
import mate.academy.model.FruitTransaction;
import mate.academy.strategy.activities.ActivityHandler;

public class ActivityStrategyImpl implements ActivityStrategy {
    private Map<FruitTransaction.Operation, ActivityHandler> activityHandlerMap;

    public ActivityStrategyImpl(Map<FruitTransaction.Operation,
            ActivityHandler> activityHandlerMap) {
        this.activityHandlerMap = activityHandlerMap;
    }

    @Override
    public ActivityHandler get(FruitTransaction.Operation operation) {
        return activityHandlerMap.get(operation);
    }
}
