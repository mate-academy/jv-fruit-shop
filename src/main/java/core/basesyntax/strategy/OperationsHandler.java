package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;

public interface OperationsHandler {
    void handler(FruitTransaction fruitTransaction);
}
