package core.basesyntax.service.strategy;

import core.basesyntax.model.Operation;
import core.basesyntax.service.strategy.handler.ActivityHandler;
import java.util.Map;

public class ActivityStrategyImpl implements ActivityStrategy {
    private final Map<Operation, ActivityHandler> activityHandlerMap;

    public ActivityStrategyImpl(Map<Operation, ActivityHandler> activityHandlerMap) {
        this.activityHandlerMap = activityHandlerMap;
    }

    @Override
    public ActivityHandler get(Operation operation) {
        return activityHandlerMap.get(operation);
    }
}
