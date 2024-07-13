package strategy;

import model.Operation;
import service.OperationHandler;

public interface OperationStrategy {
    OperationHandler getHandler(Operation operation);
}
