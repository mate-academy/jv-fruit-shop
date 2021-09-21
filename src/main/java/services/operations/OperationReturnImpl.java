package services.operations;

import model.TransactionDto;

public class OperationReturnImpl implements Operation {
    @Override
    public Integer getNewAmount(TransactionDto transactionDto, int oldAmount) {
        return oldAmount + transactionDto.getAmount();
    }
}
