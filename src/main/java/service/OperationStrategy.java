package service;

import operationtype.OperationHandler;

public interface OperationStrategy {
    OperationHandler getOperation(String operation);
}
