package main.service.interfaces;

import main.model.Operation;

public interface OperationStrategy {
    OperationHandler get(Operation operation);
}
