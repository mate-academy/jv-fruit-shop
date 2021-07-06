package app.strategy;

import app.dto.Transaction;

public interface OperationHandler {
    int apply(Transaction transactionDto);
}
