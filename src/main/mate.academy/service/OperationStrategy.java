package service;

import model.Operation;
import service.operation.Handler;

public interface OperationStrategy {
    Handler getHandler(Operation operation);
}
