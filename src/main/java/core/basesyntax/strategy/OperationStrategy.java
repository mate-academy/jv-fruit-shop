package core.basesyntax.strategy;

import core.basesyntax.enums.Operation;
import core.basesyntax.hadler.OperationHandler;

public interface OperationStrategy {
    OperationHandler get(Operation operation);
}
