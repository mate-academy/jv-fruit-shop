package strategy;

import model.Fruits;
import strategy.operations.OperationHandler;

public interface Strategy {
    OperationHandler getOperationTypeFruit(Fruits.Operation operation);
}
