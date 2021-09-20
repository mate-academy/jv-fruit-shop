package services.operations.strategy;

import services.operations.Operation;

public interface OperationsStrategy {
    Operation getOperation(String operation);
}
