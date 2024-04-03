package strategy;

import model.FruitTransaction;
import strategy.handlers.StrategyHandler;

import java.util.Map;

public class FruitStrategyImpl implements FruitStrategy {
    private Map<FruitTransaction.Operation, StrategyHandler> typeHandlerMap;
    
    public FruitStrategyImpl(Map<FruitTransaction.Operation, StrategyHandler> typeHandlerMap) {
        this.typeHandlerMap = typeHandlerMap;
    }
    @Override
    public StrategyHandler getTypeHandler(FruitTransaction.Operation type) {
        return typeHandlerMap.get(type.getCode());
    }
}
