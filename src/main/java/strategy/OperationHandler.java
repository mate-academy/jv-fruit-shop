package strategy;

import model.TransactionDto;

public interface OperationHandler {
    void apply(TransactionDto transactionDto);
}
