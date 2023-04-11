package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;

public interface TransactionStrategy {
    void process(FruitTransaction transaction);
}
