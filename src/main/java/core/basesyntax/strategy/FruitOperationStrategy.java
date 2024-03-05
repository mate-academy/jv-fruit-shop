package java.core.basesyntax.strategy;

import java.core.basesyntax.model.FruitTransaction;

public interface FruitOperationStrategy {
    void apply(FruitTransaction transaction);
}
