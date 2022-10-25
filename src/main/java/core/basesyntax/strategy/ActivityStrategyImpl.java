package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.impl.activity.ActivityHandler;
import java.util.Map;

public class ActivityStrategyImpl implements ActivityStrategy {
    private final Map<FruitTransaction.Operation, ActivityHandler> activityHandlerMap;

    public ActivityStrategyImpl(Map<FruitTransaction.Operation,
            ActivityHandler> activityHandlerMap) {
        this.activityHandlerMap = activityHandlerMap;
    }

    @Override
    public void doActivity(FruitTransaction fruitTransaction) {
        activityHandlerMap.get(fruitTransaction.getOperation()).doActivity(fruitTransaction);
    }
}
