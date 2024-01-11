package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;

public interface Strategy {
    void getOperation(FruitTransaction operation);
}
