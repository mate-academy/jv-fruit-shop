package strategy;

import java.util.Map;
import model.OperationsList;
import service.OperationHandler;

public class OperationStrategy {
    private final Map<OperationsList, OperationHandler> serviceMap;

    public OperationStrategy(Map<OperationsList, OperationHandler> serviceMap) {
        this.serviceMap = serviceMap;
    }

    public OperationHandler getOperationService(OperationsList operationsList) {
        OperationHandler operationHandler = serviceMap.get(operationsList);
        if (operationHandler == null) {
            throw new IllegalArgumentException("Unknown service type " + operationsList);
        }
        return operationHandler;
    }

    public OperationsList getOperationFromCode(String code) {
        try {
            return OperationsList.fromCode(code);
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Invalid operation code: " + code, e);
        }
    }
}
