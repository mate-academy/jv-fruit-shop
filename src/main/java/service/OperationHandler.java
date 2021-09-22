package service;

import service.impl.TransactionDto;

public interface OperationHandler {
    int getFruitAmount(TransactionDto transactionDto);
}
