package service.operation;

import model.Transaction;

public interface OperationHandler {
    void proceed(Transaction transaction);
}
