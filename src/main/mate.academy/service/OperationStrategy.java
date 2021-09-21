package service;

import service.operation.Handler;

public interface OperationStrategy {
    Handler getHandler(String operation);
}
