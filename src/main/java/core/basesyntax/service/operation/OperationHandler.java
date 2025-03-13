package core.basesyntax.service.operation;

import core.basesyntax.service.model.FruitTransaction;

public interface OperationHandler {
    FruitTransaction.Operation getOperation(String operation);

    void apply(FruitTransaction transaction);
}
