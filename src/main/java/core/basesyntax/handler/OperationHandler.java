package core.basesyntax.handler;

import core.basesyntax.models.FruitTransaction;

public interface OperationHandler {
    void handle(FruitTransaction transition);
}
