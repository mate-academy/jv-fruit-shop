package core.service;

import core.service.handlers.FruitOperationHandler;
import java.util.Map;

public class UpdateFruitsStrategyImpl implements UpdateFruitsStrategy {
    private final Map<String,FruitOperationHandler> operationsHandlerMap;

    public UpdateFruitsStrategyImpl(Map<String, FruitOperationHandler> operationsHandlerMap) {
        this.operationsHandlerMap = operationsHandlerMap;
    }

    @Override
    public FruitOperationHandler get(String fruitOperation) {
        return operationsHandlerMap.get(fruitOperation);
    }
}
