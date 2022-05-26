package strategy;

import model.FruitTransaction;
import operation.OperationHandler;

public interface Strategy {
    OperationHandler process(FruitTransaction.Operation operation);
}
