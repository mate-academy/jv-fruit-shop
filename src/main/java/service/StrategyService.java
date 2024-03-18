package service;

import model.Operation;
import strategy.OperationHandler;

public interface StrategyService {
    OperationHandler get(Operation operation);
}
