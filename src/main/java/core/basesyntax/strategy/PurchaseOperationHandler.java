package core.basesyntax.strategy;

import core.basesyntax.model.TransactionDto;

public class PurchaseOperationHandler implements OperationHandler {
    @Override
    public void apply(TransactionDto transactionDto) {
        //validate: do we have enough
    }
}
