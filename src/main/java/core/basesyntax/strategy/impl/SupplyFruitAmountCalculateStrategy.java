package core.basesyntax.strategy.impl;

import core.basesyntax.strategy.FruitAmountCalculateStrategy;

public class SupplyFruitAmountCalculateStrategy implements FruitAmountCalculateStrategy {
    @Override
    public int getFruitAmount(int amount) {
        return amount;
    }
}
