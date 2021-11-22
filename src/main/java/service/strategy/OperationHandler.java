package service.strategy;

import model.Transaction;

public interface OperationHandler {
    void execute(Transaction transaction);
}
