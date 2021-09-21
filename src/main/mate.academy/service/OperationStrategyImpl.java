package service;

import service.operation.Handler;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private final Map<String, Handler> handlerMap;

    public OperationStrategyImpl(Map<String, Handler> handlerMap) {
        this.handlerMap = handlerMap;
    }

    @Override
    public Handler getHandler(String type) {
        if (handlerMap.get(type) == null) {
            throw new RuntimeException("Invalid operation");
        }
        return handlerMap.get(type);
    }
}