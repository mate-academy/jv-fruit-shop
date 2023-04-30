package service;

import model.Operation;

public interface CalculationStrategy {
    OperationHandler get(Operation operation);
}
