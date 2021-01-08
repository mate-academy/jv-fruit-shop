package core.basesyntax.strategy;

import core.basesyntax.model.Operations;

public interface OperationStrategy {
    OperationHandler get(Operations typeOfActivity);
}
