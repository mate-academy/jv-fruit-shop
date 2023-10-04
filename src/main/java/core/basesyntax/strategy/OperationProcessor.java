package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;

public interface OperationProcessor {
    void process(FruitTransaction fruitTransaction);
}
