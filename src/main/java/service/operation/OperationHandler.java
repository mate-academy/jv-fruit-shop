package service.operation;

import model.Transaction;

public interface OperationHandler {
    void performOperation(Transaction transaction);
}
