package core.basesyntax.strategy;

import core.basesyntax.dto.Transaction;

public interface OperationHandler {
    int apply(Transaction transaction);
}
