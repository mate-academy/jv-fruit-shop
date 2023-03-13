package core.basesyntax.strategy;

import core.basesyntax.handlers.OperationHandler;

public interface Strategy {
    OperationHandler get(String operation);
}
