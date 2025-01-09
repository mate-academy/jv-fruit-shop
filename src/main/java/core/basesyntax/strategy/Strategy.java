package core.basesyntax.strategy;

import core.basesyntax.handler.OperationHandler;
import core.basesyntax.transactor.Operation;

public interface Strategy {
    OperationHandler get(Operation operation);
}
