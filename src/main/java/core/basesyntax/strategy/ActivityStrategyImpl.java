package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.activity.TransactionHandler;
import java.util.Map;

public class ActivityStrategyImpl implements ActivityStrategy {
    private Map<FruitTransaction.Operation, TransactionHandler> activityHandlerMap;

    public ActivityStrategyImpl(Map<FruitTransaction.Operation,
            TransactionHandler> activityHandlerMap) {
        this.activityHandlerMap = activityHandlerMap;
    }

    @Override
    public TransactionHandler get(FruitTransaction.Operation operation) {
        return activityHandlerMap.get(operation);
    }
}
