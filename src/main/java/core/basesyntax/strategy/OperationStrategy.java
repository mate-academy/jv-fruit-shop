package core.basesyntax.strategy;

import core.basesyntax.db.Operation;

public interface OperationStrategy {
    OperationHandler getHandler(Operation operation);
}
