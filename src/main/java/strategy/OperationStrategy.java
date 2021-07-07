package strategy;

import java.util.Map;

public class OperationStrategy {
    private Map<String, OperationHandler> operationsMap;

    public OperationStrategy(Map<String, OperationHandler> map) {
        operationsMap = map;
    }

    public OperationHandler getOperationStrategy(String operation) {
        if (isOperationExist(operation)) {
            return operationsMap.get(operation);
        }
        throw new RuntimeException("There is no operation like this: " + operation);
    }

    public boolean isOperationExist(String operation) {
        return operationsMap.containsKey(operation);
    }
}
