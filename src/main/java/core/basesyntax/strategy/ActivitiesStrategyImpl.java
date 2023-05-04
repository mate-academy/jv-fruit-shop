package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.activities.ActivitiesHandler;

import java.util.Map;

public class ActivitiesStrategyImpl implements ActivitiesStrategy{
    private final Map<FruitTransaction.Operation, ActivitiesHandler> activitiesHandlersMap;

    public ActivitiesStrategyImpl(Map<FruitTransaction.Operation, ActivitiesHandler> activitiesHandlersMap) {
        this.activitiesHandlersMap = activitiesHandlersMap;
    }

    @Override
    public ActivitiesHandler get(FruitTransaction.Operation operation) {
        return activitiesHandlersMap.get(operation);
    }
}
