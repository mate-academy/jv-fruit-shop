package basesyntax.service;

import basesyntax.model.FruitTransaction;

public interface OperationHandler {
    void apply(FruitTransaction transaction);
}
