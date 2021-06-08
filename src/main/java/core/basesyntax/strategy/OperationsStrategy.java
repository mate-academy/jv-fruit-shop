package core.basesyntax.strategy;

import core.basesyntax.operations.Operation;
import core.basesyntax.operations.Operations;

public interface OperationsStrategy {
    Operation get(Operations type);
}
