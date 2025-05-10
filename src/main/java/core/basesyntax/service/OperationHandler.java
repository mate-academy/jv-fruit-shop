package core.basesyntax.service;

import core.basesyntax.model.Transaction;

public interface OperationHandler<T extends Transaction> {
    void handle(T transaction);
}
