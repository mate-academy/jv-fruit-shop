package core.basesyntax.handler;

import core.basesyntax.dto.Transaction;

public interface OperationHandler {
    int apply(Transaction transactionDto);
}
