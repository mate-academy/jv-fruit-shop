package service.impl;

import java.util.Map;
import model.FruitActivitiesModel;
import service.OperationStrategy;
import strategy.OperationHandler;

public class OperationStrategyImpl implements OperationStrategy {
    private final Map<FruitActivitiesModel.Operation, OperationHandler> operationHandlerMap;

    public OperationStrategyImpl(Map<FruitActivitiesModel.Operation,
            OperationHandler> operationHandlerMap) {
        this.operationHandlerMap = operationHandlerMap;
    }

    @Override
    public OperationHandler get(FruitActivitiesModel.Operation type) {
        return operationHandlerMap.get(type);
    }
}
