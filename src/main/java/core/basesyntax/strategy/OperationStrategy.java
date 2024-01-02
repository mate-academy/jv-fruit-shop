package core.basesyntax.strategy;

import core.basesyntax.services.handlers.OperationHandler;

public interface OperationStrategy {
    OperationHandler get(String code);
}
