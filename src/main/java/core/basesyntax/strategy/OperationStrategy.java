package core.basesyntax.strategy;

import core.basesyntax.dto.Operation;
import core.basesyntax.strategy.handler.OperationHandler;

public interface OperationStrategy {
    OperationHandler findHandler(Operation operation);
}
