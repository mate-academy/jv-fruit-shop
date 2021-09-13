package shop.service;

import shop.service.operations.Operation;

public interface OperationsStrategy {
    Operation get(String operationIndex);
}
