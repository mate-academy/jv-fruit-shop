package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;

public interface OperationStrategy {
    void apply(FruitTransaction transaction);
}
