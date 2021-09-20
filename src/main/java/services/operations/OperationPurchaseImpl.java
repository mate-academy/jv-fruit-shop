package services.operations;

import model.TransactionDto;

public class OperationPurchaseImpl implements Operation {
    @Override
    public Integer getNewAmount(TransactionDto transactionDto, int oldAmount) {
        return oldAmount - transactionDto.getAmount();
    }
}
