package core.basesyntax.strategy;

import core.basesyntax.enums.Operation;
import core.basesyntax.strategy.impl.OperationHandler;

public interface OperationStrategy {
    public OperationHandler get(Operation operation);
}
