package strategy;

import model.FruitTransaction;
import service.operation.TransactionHandler;

public interface OperationStrategy {
    TransactionHandler getHandler(FruitTransaction.Operation operation);
}
