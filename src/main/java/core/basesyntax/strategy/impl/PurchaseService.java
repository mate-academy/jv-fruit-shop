package core.basesyntax.strategy.impl;

import core.basesyntax.strategy.ActivityService;

public class PurchaseService implements ActivityService {

    @Override
    public Integer getNewCount(int curCount, int count) {
        if (curCount < count) {
            throw new RuntimeException("Not enough fruit!");
        }
        return curCount - count;
    }
}
