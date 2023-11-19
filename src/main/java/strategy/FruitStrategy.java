package strategy;

import model.Operation;

public interface FruitStrategy {
    OperationHandler getOperationHandler(Operation operation);
}


