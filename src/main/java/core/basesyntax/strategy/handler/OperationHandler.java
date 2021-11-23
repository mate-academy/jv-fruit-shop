package core.basesyntax.strategy.handler;

import core.basesyntax.dto.Transaction;

public interface OperationHandler {
    int apply(Transaction transaction);
}
