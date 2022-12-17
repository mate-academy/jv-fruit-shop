package service.impl;

import java.util.Map;
import model.FruitTransaction;
import service.ActivityStrategy;
import service.activity.ActivityHandler;

public class ActivityStrategyImpl implements ActivityStrategy {
    private Map<FruitTransaction.Operation, ActivityHandler> operationActivityHandlerMap;

    public ActivityStrategyImpl(Map<FruitTransaction.Operation,
            ActivityHandler> operationActivityHandlerMap) {
        this.operationActivityHandlerMap = operationActivityHandlerMap;
    }

    @Override
    public ActivityHandler getHandler(FruitTransaction.Operation operation) {
        return operationActivityHandlerMap.get(operation);
    }
}
