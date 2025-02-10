package core.basesyntax.strategy;

import core.basesyntax.models.FruitTransaction;

public interface OperationHandler {
    void apply(FruitTransaction transaction);
}
