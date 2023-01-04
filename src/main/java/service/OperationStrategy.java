package service;

import model.Operation;

public interface OperationStrategy {
    OperationHandle get(Operation type);
}
