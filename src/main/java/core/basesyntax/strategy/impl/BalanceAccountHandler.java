package core.basesyntax.strategy.impl;

import core.basesyntax.model.Accountable;
import core.basesyntax.strategy.AccountHandler;

public class BalanceAccountHandler implements AccountHandler {
    @Override
    public void account(Accountable fruit, int amount) {
        fruit.setAmount(amount);
    }
}
