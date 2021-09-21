package service;

import model.Operation;
import service.operation.OperationHandler;

public interface OperationStrategy {
    OperationHandler get(Operation.Type operation);
}
