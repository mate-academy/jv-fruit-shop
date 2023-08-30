package strategy;

import model.FruitTransaction;
import service.operation.OperationTransaction;

public interface OperationStrategy {
    OperationTransaction getOperation(FruitTransaction.Operation operation);
}
