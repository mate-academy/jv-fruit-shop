package core.basesyntax.strategy;

import core.basesyntax.FruitTransaction;

public interface TransactionProcessor {
    void process(FruitTransaction transaction);
}
