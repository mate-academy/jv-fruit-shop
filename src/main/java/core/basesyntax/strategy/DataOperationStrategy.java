package core.basesyntax.strategy;

import core.basesyntax.db.operations.DataOperation;
import core.basesyntax.model.Operation;

public interface DataOperationStrategy {
    DataOperation get(Operation operation);
}
