package service;

import model.FruitTransaction;
import strategy.OperationHandler;

public interface StrategyService {
    OperationHandler get(FruitTransaction.Operation operation);
}
