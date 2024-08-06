package core.basesyntax.service.operations;

import core.basesyntax.model.FruitTransaction;

public interface OperationHandler {
    void handle(FruitTransaction transaction);
}
