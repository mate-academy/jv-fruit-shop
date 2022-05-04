package strategy.impl;

import java.util.Map;
import model.FruitTransaction;
import strategy.OperationHandler;
import strategy.StrategyService;

public class StrategyServiceImpl implements StrategyService {
    private final Map<FruitTransaction.Operation, OperationHandler> handlerMap;

    public StrategyServiceImpl(Map<FruitTransaction.Operation, OperationHandler> strategyMap) {
        this.handlerMap = strategyMap;
    }

    public OperationHandler get(FruitTransaction.Operation operation) {
        return handlerMap.get(operation);
    }
}
