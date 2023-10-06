package service.impl;

import java.util.Map;
import model.FruitTransaction;
import service.ActivitiesStrategy;
import service.activities.ActivitiesHandler;

public class ActivitiesStrategyImpl implements ActivitiesStrategy {
    private Map<FruitTransaction.Operation, ActivitiesHandler> activitiesHandlerMap;

    public ActivitiesStrategyImpl(Map<FruitTransaction.Operation,
            ActivitiesHandler> activitiesHandlerMap) {
        this.activitiesHandlerMap = activitiesHandlerMap;
    }

    @Override
    public ActivitiesHandler get(FruitTransaction.Operation operation) {
        return activitiesHandlerMap.get(operation);
    }
}
