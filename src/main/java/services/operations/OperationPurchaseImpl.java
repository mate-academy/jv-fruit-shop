package services.operations;

import model.TransactionDto;

public class OperationPurchaseImpl implements Operation {
    @Override
    public Integer getNewAmount(TransactionDto transactionDto, int oldAmount) {
        if (transactionDto.getAmount() > oldAmount) {
            throw new OperationException("Amount is low then transaction amount. ERROR!");
        }
        return oldAmount - transactionDto.getAmount();
    }
}
