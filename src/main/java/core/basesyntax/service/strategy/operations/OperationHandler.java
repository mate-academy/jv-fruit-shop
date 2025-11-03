package core.basesyntax.service.strategy.operations;

import core.basesyntax.model.FruitTransaction;

public interface OperationHandler {
    void apply(FruitTransaction transaction);
}
