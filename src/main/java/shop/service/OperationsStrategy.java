package shop.service;

import shop.service.operations.OperationHandler;

public interface OperationsStrategy {
    OperationHandler get(String operation);
}
