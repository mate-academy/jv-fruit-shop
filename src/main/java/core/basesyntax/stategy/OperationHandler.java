package core.basesyntax.stategy;

import core.basesyntax.model.TransactionDto;

public interface OperationHandler {
    void apply(TransactionDto transactionDto);
}
