package service;

import service.operation.OperationHandler;

public interface OperationStrategy {
    OperationHandler get(String operation);
}
