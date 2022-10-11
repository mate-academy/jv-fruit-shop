package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;

public interface OperationProcessor {
    void process(FruitTransaction fruitTransaction);
}
