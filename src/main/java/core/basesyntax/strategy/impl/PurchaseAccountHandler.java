package core.basesyntax.strategy.impl;

import core.basesyntax.model.Accountable;
import core.basesyntax.strategy.AccountHandler;

public class PurchaseAccountHandler implements AccountHandler {
    @Override
    public void account(Accountable fruit, int amount) {
        int newAmount = fruit.getAmount() - amount;
        if (newAmount >= 0) {
            fruit.setAmount(fruit.getAmount() - amount);
        } else {
            throw new RuntimeException("Negative balance");
        }
    }
}
