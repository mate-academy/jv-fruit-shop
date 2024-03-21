package core.basesyntax.strategy.impl;

import core.basesyntax.strategy.ActivityStrategy;

public class BalanceActivityStrategy implements ActivityStrategy {
    @Override
    public int calculateQuantity(int oldQuantity, int activityQuantity) {
        return activityQuantity;
    }
}
