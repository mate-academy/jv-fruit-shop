package core.basesyntax.services;

import core.basesyntax.models.FruitTransaction;

public interface OperationHandler {
    void apply(FruitTransaction transaction);
}
