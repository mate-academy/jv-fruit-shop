package services.operations;

import model.TransactionDto;

public class OperationBalanceImpl implements Operation {

    @Override
    public Integer getNewAmount(TransactionDto transactionDto, int oldAmount) {
        return transactionDto.getAmount();
    }
}
