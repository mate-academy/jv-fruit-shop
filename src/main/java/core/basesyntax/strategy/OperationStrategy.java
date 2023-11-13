package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;

public interface OperationStrategy {
    void apply(FruitTransaction fruitTransaction);
}
