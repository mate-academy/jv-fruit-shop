package service.impl;

import java.util.Map;
import model.FruitTransaction;
import service.ActivitiesStrategy;
import service.activities.TransactionHandler;

public class ActivitiesStrategyImpl implements ActivitiesStrategy {
    private final Map<FruitTransaction.Operation, TransactionHandler> activitiesHandlerMap;

    public ActivitiesStrategyImpl(Map<FruitTransaction.Operation,
            TransactionHandler> activitiesHandlerMap) {
        this.activitiesHandlerMap = activitiesHandlerMap;
    }

    @Override
    public TransactionHandler get(FruitTransaction.Operation operation) {
        return activitiesHandlerMap.get(operation);
    }
}
