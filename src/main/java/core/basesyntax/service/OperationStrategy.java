package core.basesyntax.service;

import core.basesyntax.model.Transaction;

public interface OperationStrategy<T extends Transaction> {
    OperationHandler<T> get(T transaction);
}
