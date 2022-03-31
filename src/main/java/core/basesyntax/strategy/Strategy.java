package core.basesyntax.strategy;

import core.basesyntax.service.operation.OperationHandler;

public interface Strategy {
    OperationHandler get(String operation);
}
