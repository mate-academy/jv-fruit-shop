package service;

import service.operation.Operation;

public interface OperationStrategy {
    Operation get(String activity);
}
