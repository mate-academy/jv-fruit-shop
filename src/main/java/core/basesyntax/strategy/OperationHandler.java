package core.basesyntax.strategy;

import core.basesyntax.model.TransactionDto;

public interface OperationHandler {
    boolean apply(TransactionDto transactionDto);
}
