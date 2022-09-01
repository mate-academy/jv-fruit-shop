package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;

public interface TransactionHandler {
    void apply(FruitTransaction transaction);
}
