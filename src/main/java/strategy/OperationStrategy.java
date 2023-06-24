package strategy;

import handlers.OperationTypeHandler;
import model.FruitTransaction;

public interface OperationStrategy {
    OperationTypeHandler getHandlerByOperation(FruitTransaction.Operation type);
}
