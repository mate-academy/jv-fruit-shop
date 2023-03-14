package service;

import model.Operation;
import strategy.OperationHandler;

public interface OperationStrategy {
    OperationHandler get(Operation actionType);
}
