package core.basesyntax.strategy.handler;

import core.basesyntax.dto.TransactionDto;

public interface OperationHandler {
    boolean apply(TransactionDto transactionDto);
}
