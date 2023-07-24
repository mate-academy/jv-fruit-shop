package core.basesyntax.strategy.handlers;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;

public interface OperationHandler {
    void handle(FruitTransaction transaction);

    Operation getOperationType();
}
