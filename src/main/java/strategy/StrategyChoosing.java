package strategy;

import handlers.OperationTypeHandler;
import model.FruitTransaction;

public interface StrategyChoosing {
    OperationTypeHandler getStrategy(FruitTransaction.Operation type);
}
