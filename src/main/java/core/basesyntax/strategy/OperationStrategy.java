package core.basesyntax.strategy;

import core.basesyntax.db.Storage;

public interface OperationStrategy {
    OperationHandler get(Storage.Operation operation);
}
