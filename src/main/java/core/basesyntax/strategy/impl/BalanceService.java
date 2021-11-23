package core.basesyntax.strategy.impl;

import core.basesyntax.strategy.ActivityService;

public class BalanceService implements ActivityService {

    @Override
    public Integer getNewCount(int curCount, int count) {
        return count;
    }
}
