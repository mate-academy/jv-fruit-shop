package service.operation;

import model.Transaction;

public interface OperationStrategy {
    OperationHandler getOperation(Transaction transaction);
}
