package core.basesyntax.strategy;

import core.basesyntax.operations.Operation;

public interface OperationStrategy {
    Operation get(String typeOfOperation);
}
