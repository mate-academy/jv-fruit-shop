package core.basesyntax.service.operation;

import core.basesyntax.model.FruitTransaction;

public interface OperationHandler {
    void recount(FruitTransaction transaction);
}
