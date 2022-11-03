package strategy;

import model.FruitTransaction;
import operations.OperationHandler;

public interface OperationStrategy {
    OperationHandler get(FruitTransaction.Operation operation);
}
