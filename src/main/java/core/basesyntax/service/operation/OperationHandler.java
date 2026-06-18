package core.basesyntax.service.operation;

import core.basesyntax.service.FruitTransaction;

public interface OperationHandler {
    void handle(FruitTransaction transaction);
}
