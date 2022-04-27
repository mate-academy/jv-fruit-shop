package strategy;

import operation.OperationHandler;

public interface OperationStrategy {
    OperationHandler get(String operation);
}
