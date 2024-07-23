package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;

public interface TransactionProcess {
    void process(FruitTransaction fruitTransaction);
}
