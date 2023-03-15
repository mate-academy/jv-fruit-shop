package strategy;

import handler.OperationHandler;
import model.FruitTransaction;

public interface OperationStrategy {
    OperationHandler get(FruitTransaction.Operation operation);
}
