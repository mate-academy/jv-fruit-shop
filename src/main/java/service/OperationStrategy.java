package service;

import model.Operation;

public interface OperationStrategy {
    OperationHandler get(Operation type);
}
