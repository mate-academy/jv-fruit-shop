package service.impl;

import java.util.Map;
import model.Operation;
import service.ApplyStrategyService;
import strategy.OperationHandler;

public class ApplyStategyServiceImpl implements ApplyStrategyService {
    private Map<Operation, OperationHandler> handlerMap;

    public ApplyStategyServiceImpl(Map<Operation, OperationHandler> handlerMap) {
        this.handlerMap = handlerMap;
    }

    @Override
    public OperationHandler getHandler(Operation operation) {
        return handlerMap.get(operation);
    }
}
