package core.basesyntax.strategy;

import core.basesyntax.model.ProductTransaction;
import core.basesyntax.strategy.activities.ActivitiesHandler;
import java.util.Map;

public class ActivitiesStrategyImp implements ActivitiesStrategy {
    private final Map<ProductTransaction.Operation, ActivitiesHandler> activitiesHandlerMap;

    public ActivitiesStrategyImp(Map<ProductTransaction.Operation,
            ActivitiesHandler> activitiesHandlerMap) {
        this.activitiesHandlerMap = activitiesHandlerMap;
    }

    @Override
    public ActivitiesHandler get(ProductTransaction.Operation type) {
        return activitiesHandlerMap.get(type);
    }
}
