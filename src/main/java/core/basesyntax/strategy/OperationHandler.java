package core.basesyntax.strategy;

import core.basesyntax.model.TransactionDto;

public interface OperationHandler {
    void apply(TransactionDto transactionDto);
}
