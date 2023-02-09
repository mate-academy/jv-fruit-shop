package core.basesyntax.strategy;

import core.basesyntax.operations.Operational;

public interface OperationStrategy {
    Operational get(String typeOfOperation);
}
