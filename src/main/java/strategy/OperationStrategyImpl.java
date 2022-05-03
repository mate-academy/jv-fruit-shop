package strategy;

import java.util.HashMap;
import java.util.Map;
import model.Fruit;
import service.OperationHandler;

public class OperationStrategyImpl implements OperationStrategy {
    private Map<String, OperationHandler> operationHandlerMap;

    public OperationStrategyImpl() {
        this.operationHandlerMap = new HashMap<>();
    }

    @Override
    public void addOperation(String type, OperationHandler operation) {
        operationHandlerMap.put(type, operation);
    }

    @Override
    public void operationCheck(String type, Fruit key, String value) {
        operationHandlerMap.get(type).doOperation(key, value);
    }
}
