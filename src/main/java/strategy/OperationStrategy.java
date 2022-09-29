package strategy;

import model.FruitTransaction;
import opareation.OperationHandler;

public interface OperationStrategy {
    OperationHandler get(FruitTransaction.Operation operation);
}
