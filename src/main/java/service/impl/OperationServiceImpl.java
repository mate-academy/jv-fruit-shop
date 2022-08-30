package service.impl;

import java.util.Map;
import model.Operation;
import service.OperationService;
import strategy.OperationHandler;

public class OperationServiceImpl implements OperationService {
    private Map<Operation, OperationHandler> handlerMap;

    public OperationServiceImpl(Map<Operation, OperationHandler> handlerMap) {
        this.handlerMap = handlerMap;
    }

    @Override
    public OperationHandler getHandler(Operation operation) {
        return handlerMap.get(operation);
    }
}
