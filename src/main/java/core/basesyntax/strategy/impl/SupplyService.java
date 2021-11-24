package core.basesyntax.strategy.impl;

import core.basesyntax.strategy.ActivityService;

public class SupplyService implements ActivityService {

    @Override
    public Integer getNewCount(int curCount, int count) {
        return curCount + count;
    }
}
