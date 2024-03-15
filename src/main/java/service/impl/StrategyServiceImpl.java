package service.impl;

import java.util.Map;
import model.FruitTransaction;
import service.StrategyService;
import strategy.OperationHandler;

public class StrategyServiceImpl implements StrategyService {
    private Map<FruitTransaction.Operation, OperationHandler> operationHandlerMap;

    public StrategyServiceImpl(Map<FruitTransaction.Operation,
            OperationHandler> operationHandlerMap) {
        this.operationHandlerMap = operationHandlerMap;
    }

    @Override
    public OperationHandler get(FruitTransaction.Operation operation) {
        return operationHandlerMap.get(operation);
    }
}
