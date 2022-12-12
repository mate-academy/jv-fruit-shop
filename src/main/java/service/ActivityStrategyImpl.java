package service;

import java.util.Map;
import model.FruitTransaction;
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

    @Override
    public FruitTransaction.Operation getOperation(String operation) {
        return operationActivityHandlerMap.keySet().stream()
                .filter(k -> k.getOperation().contains(operation))
                .findAny()
                .orElseThrow(() -> new RuntimeException("Passed wrong operation:" + operation));
    }
}
