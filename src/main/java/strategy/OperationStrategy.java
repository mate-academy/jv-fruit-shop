package strategy;

import service.OperationHandler;

public interface OperationStrategy {
    void addOperation(String type, OperationHandler operation);

    void operationCheck(String type, String key, String value);
}
