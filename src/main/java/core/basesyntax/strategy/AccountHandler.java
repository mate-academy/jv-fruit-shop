package core.basesyntax.strategy;

import core.basesyntax.model.Accountable;

public interface AccountHandler {
    void account(Accountable fruit, int amount);
}
