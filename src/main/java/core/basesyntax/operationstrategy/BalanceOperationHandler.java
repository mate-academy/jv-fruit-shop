package core.basesyntax.operationstrategy;

import core.basesyntax.model.TransactionDto;

public class BalanceOperationHandler implements OperationHandler {
    @Override
    public Integer doOperation(TransactionDto transactionDto) {
        return transactionDto.getFruitAmount();
    }
}
