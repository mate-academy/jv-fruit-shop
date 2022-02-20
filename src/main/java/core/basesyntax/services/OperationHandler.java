package core.basesyntax.services;

import core.basesyntax.models.TransactionDto;

public interface OperationHandler {
    void apply(TransactionDto transactionDto);
}
