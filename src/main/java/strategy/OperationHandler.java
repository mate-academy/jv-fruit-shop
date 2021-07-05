package strategy;

import dto.Transaction;

public interface OperationHandler {
    int perform(Transaction transferObject);
}
