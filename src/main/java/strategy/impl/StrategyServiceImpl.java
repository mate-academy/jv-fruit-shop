package strategy.impl;

import java.util.Map;
import model.Operation;
import strategy.OperationHandler;
import strategy.StrategyService;

public class StrategyServiceImpl implements StrategyService {
    private final Map<Operation, OperationHandler> handlerMap;

    public StrategyServiceImpl(Map<Operation, OperationHandler> strategyMap) {
        this.handlerMap = strategyMap;
    }

    public OperationHandler get(Operation operation) {
        return handlerMap.get(operation);
    }
}
