package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;

public interface OperationsStrategy {
    void handle(FruitTransaction fruitTransaction);
}
