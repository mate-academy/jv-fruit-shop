package core.basesyntax.strategy;

import core.basesyntax.model.TransactionDto;

public interface OperationHandler {
    public void apply(TransactionDto transactionDto);
}
