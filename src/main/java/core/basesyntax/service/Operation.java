package core.basesyntax.service;

import core.basesyntax.model.OperationWithFruit;

public interface Operation {
    core.basesyntax.strategy.Operation getOperationHandler(OperationWithFruit operation);
}
