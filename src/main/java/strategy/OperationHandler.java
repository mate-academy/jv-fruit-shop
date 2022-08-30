package strategy;

import model.Transaction;

public interface OperationHandler {
    void apply(Transaction transaction);
}
