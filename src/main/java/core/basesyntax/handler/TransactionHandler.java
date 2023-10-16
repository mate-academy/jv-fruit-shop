package core.basesyntax.handler;

import core.basesyntax.model.FruitTransaction;

public interface TransactionHandler {
    void apply(FruitTransaction transaction);
}
