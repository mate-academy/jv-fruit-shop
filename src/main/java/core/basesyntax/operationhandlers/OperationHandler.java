package core.basesyntax.operationhandlers;

import core.basesyntax.model.FruitTransaction;

public interface OperationHandler {
    void apply(FruitTransaction transaction);
}
