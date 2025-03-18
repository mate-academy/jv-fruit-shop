package core.basesyntax.operationhandlers;

import core.basesyntax.model.FruitTransactionImpl;

public interface OperationHandler {
    void apply(FruitTransactionImpl transaction);
}
