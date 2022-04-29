package service;

import model.Operation;
import strategy.OperationHandler;

public interface ApplyStrategyService {
    OperationHandler getHandler(Operation operation);
}
