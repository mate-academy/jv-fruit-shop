package service;

import service.operation.OperationHandler;

public interface OperationStrategy {
    default OperationHandler get(String operation) {
        return null;
    }
}
