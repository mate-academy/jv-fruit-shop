package service;

import service.operation.Handler;

public interface OperationStrategy {
    Handler get(String operation);
}
