package services.operations;

import model.TransactionDto;

public interface Operation {
    Integer getNewAmount(TransactionDto transactionDto, int oldAmount);
}
