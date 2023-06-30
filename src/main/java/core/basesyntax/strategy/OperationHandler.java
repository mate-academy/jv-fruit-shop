package core.basesyntax.strategy;

import core.basesyntax.dto.Transaction;

public interface OperationHandler {
    void handle(Transaction transaction);
}
