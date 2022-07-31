package strategy;

import handler.OperationHandler;
import model.FruitTransaction;

public interface OperationStrategy {
    OperationHandler getHandler(FruitTransaction.Operation operation);
}
