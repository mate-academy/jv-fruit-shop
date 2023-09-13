package strategy;

import model.Operation;
import service.OperationHandler;

public interface OperationStrategy {
    OperationHandler get(Operation operation);
}
