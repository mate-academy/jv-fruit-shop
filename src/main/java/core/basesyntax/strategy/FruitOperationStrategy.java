package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;

public interface FruitOperationStrategy {
    void apply(FruitTransaction transaction);
}

