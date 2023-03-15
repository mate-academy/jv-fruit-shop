package strategy;

import handlers.OperationTypeHandler;
import java.util.Map;
import model.FruitTransaction;

public class StrategyImpl implements StrategyChoosing {
    private final Map<FruitTransaction.Operation, OperationTypeHandler> strategy;

    public StrategyImpl(Map<FruitTransaction.Operation, OperationTypeHandler> strategy) {
        this.strategy = strategy;
    }

    @Override
    public OperationTypeHandler getStrategy(FruitTransaction.Operation type) {
        return strategy.get(type);
    }
}
