package service.impl;

import java.util.Map;
import model.Operation;
import service.StrategyService;
import strategy.OperationHandler;

public class StrategyServiceImpl implements StrategyService {
    private Map<Operation, OperationHandler> operationHandlerMap;

    public StrategyServiceImpl(Map<Operation,
            OperationHandler> operationHandlerMap) {
        this.operationHandlerMap = operationHandlerMap;
    }

    @Override
    public OperationHandler get(Operation operation) {
        return operationHandlerMap.get(operation);
    }
}
