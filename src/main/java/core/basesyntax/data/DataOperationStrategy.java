package core.basesyntax.data;

import core.basesyntax.data.operations.DataOperation;

public interface DataOperationStrategy {
    DataOperation get(Operation operation);
}
