package core.strategy;

import core.model.Transaction;
import core.service.handler.OperationHandler;

public interface OperationStrategy {
    OperationHandler getHandler(Transaction.Operation op);
}
