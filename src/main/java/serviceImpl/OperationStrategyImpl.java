package serviceImpl;

import model.fruitActivitiesModel;
import service.OperationStrategy;
import strategy.OperationHandler;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private final Map<fruitActivitiesModel.Operation, OperationHandler> operationHandlerMap;

    public OperationStrategyImpl(Map<fruitActivitiesModel.Operation,
            OperationHandler> operationHandlerMap) {
        this.operationHandlerMap = operationHandlerMap;
    }

    @Override
    public OperationHandler get(fruitActivitiesModel.Operation type) {
        return operationHandlerMap.get(type);
    }
}