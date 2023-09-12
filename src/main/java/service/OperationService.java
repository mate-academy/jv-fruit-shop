package service;

import strategy.OperationHandler;

public interface OperationService {
    OperationHandler createOperation(String operationSymbol);
}
