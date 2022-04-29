package service;

import model.Operation;
import strategy.OperationHandler;

public interface OperationService {
    OperationHandler getHandler(Operation operation);
}
