package strategy;

import model.FruitTransaction;
import strategy.operations.OperationHandler;

public interface Strategy {
    OperationHandler get(FruitTransaction.Operation operation);
}
