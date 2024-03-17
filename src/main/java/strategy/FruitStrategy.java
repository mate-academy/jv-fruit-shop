package strategy;

import model.FruitTransaction;
import strategy.handlers.StrategyHandler;

public interface FruitStrategy {
    public StrategyHandler getTypeHandler(FruitTransaction.Operation type);
}
