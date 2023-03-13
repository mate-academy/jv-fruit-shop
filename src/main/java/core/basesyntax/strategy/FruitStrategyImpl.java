package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.activities.ActivitiesHandler;
import java.util.Map;

public class FruitStrategyImpl implements FruitStrategy {
    private Map<FruitTransaction.Operation, ActivitiesHandler> activitiesHandlerMap;

    public FruitStrategyImpl(Map<FruitTransaction.Operation,
            ActivitiesHandler> activitiesHandlerMap) {
        this.activitiesHandlerMap = activitiesHandlerMap;
    }

    @Override
    public ActivitiesHandler get(FruitTransaction.Operation operation) {
        return activitiesHandlerMap.get(operation);
    }
}
