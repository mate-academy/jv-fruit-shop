package strategy;

import OpareationHandler.OperationHandler;
import model.FruitTransaction;

public interface OperationStrategy {
    OperationHandler get(FruitTransaction.Operation operation);
}
