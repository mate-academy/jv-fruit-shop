package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.activity.ActivityHandler;
import java.util.Map;

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
