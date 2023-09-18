package core.basesyntax.operation;

import core.basesyntax.FruitTransaction;

public interface Operation {
    void changeBalances(FruitTransaction transaction);
}
