package strategy;

import model.FruitTransaction;

public interface StrategyService {
    OperationHandler get(FruitTransaction.Operation operation);
}
