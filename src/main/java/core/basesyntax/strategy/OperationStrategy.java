package core.basesyntax.strategy;

import core.basesyntax.service.OperationHandler;

public interface OperationStrategy {
    OperationHandler get(String operation);
}
