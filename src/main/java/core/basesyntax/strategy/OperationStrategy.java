package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Operation;

public interface OperationStrategy {
    void applyOperation(Operation operation, String fruit,
                        int quantity, Storage storage);
}
