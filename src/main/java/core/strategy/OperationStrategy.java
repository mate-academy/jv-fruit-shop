package core.strategy;

import core.model.Transaction;
import core.strategy.handler.OperationHandler;

public interface OperationStrategy {
    OperationHandler getOperationHandler(Transaction.Operation operation);
}
