package core.basesyntax.strategy.impl;

import core.basesyntax.strategy.ActivityStrategy;

public class ReturnActivityStrategy implements ActivityStrategy {
    @Override
    public int calculateQuantity(int oldQuantity, int activityQuantity) {
        return oldQuantity + activityQuantity;
    }
}
