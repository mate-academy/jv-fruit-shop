package core.basesyntax.strategy.impl;

import core.basesyntax.model.Accountable;
import core.basesyntax.strategy.AccountHandler;

public class ReturnAccountHandler implements AccountHandler {
    @Override
    public void account(Accountable fruit, int amount) {
        fruit.setAmount(fruit.getAmount() + amount);
    }
}
