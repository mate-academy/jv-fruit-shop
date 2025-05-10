package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;

public interface ActivityHandler {
    void updateBalance(FruitTransaction transaction);
}
