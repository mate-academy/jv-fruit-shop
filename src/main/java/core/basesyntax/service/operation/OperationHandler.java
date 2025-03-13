package core.basesyntax.service.operation;

import core.basesyntax.service.model.FruitTransaction;

public interface OperationHandler {
    void apply(FruitTransaction transaction);
}
