package strategy;

import model.FruitTransaction;
import service.operation.OperationHandler;

public interface TransactionStrategy {
    OperationHandler getOperation(FruitTransaction.Operation operation);
}
