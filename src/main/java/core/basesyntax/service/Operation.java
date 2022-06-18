package core.basesyntax.service;

import core.basesyntax.model.OperationWithFruit;
import core.basesyntax.strategy.OperationHandler;

public interface Operation {
    OperationHandler getOperationHandler(OperationWithFruit operation);
}
