package myFruitShop.Service;

import myFruitShop.Service.Operations.OperationHandler;
import myFruitShop.model.OperationType;


import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    Map<OperationType, OperationHandler> operationHandlerMap;

    public OperationStrategyImpl(Map<OperationType, OperationHandler> operationHandlerMap) {
        this.operationHandlerMap = operationHandlerMap;
    }

    @Override
    public OperationHandler get(OperationType operation) {
        return operationHandlerMap.get(operation);
    }
}
