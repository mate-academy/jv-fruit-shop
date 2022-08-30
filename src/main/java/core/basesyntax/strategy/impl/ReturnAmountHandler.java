package core.basesyntax.strategy.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.strategy.AmountHandler;

public class ReturnAmountHandler implements AmountHandler {
    @Override
    public int changeAmount(Fruit fruit, int amount) {
        return fruit.getAmount() + amount;
    }
}
