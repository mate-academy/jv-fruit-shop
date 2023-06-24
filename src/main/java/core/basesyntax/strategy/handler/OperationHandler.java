package core.basesyntax.strategy.handler;

import core.basesyntax.model.TransactionDto;

public interface OperationHandler {
    void apply(TransactionDto transactionDto);
}
