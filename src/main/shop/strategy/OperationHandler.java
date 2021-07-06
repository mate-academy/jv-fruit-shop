package strategy;

import dto.Transaction;

public interface OperationHandler {
    int apply(Transaction transactionDto);
}
