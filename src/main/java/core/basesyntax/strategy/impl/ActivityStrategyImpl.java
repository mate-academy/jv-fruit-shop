package core.basesyntax.strategy.impl;

import core.basesyntax.model.ActivityType;
import core.basesyntax.strategy.ActivityStrategy;
import core.basesyntax.strategy.activities.ActivityService;
import core.basesyntax.strategy.activities.BalanceService;
import core.basesyntax.strategy.activities.PurchaseService;
import core.basesyntax.strategy.activities.ReturnService;
import core.basesyntax.strategy.activities.SupplyService;
import java.util.HashMap;
import java.util.Map;

public class ActivityStrategyImpl implements ActivityStrategy {
    private Map<ActivityType, ActivityService> activityStrategyMap;

    public ActivityStrategyImpl() {
        activityStrategyMap = new HashMap<>();
        activityStrategyMap.put(ActivityType.BALANCE, new BalanceService());
        activityStrategyMap.put(ActivityType.PURCHASE, new PurchaseService());
        activityStrategyMap.put(ActivityType.RETURN, new ReturnService());
        activityStrategyMap.put(ActivityType.SUPPLY, new SupplyService());
    }

    @Override
    public ActivityService getActivity(ActivityType activityType) {
        return activityStrategyMap.get(activityType);
    }
}
