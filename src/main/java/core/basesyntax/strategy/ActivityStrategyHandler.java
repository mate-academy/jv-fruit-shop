package core.basesyntax.strategy;

import core.basesyntax.enums.ActivityType;
import core.basesyntax.exception.UnsupportedActivityException;
import core.basesyntax.strategy.impl.BalanceActivityStrategy;
import core.basesyntax.strategy.impl.PurchaseActivityStrategy;
import core.basesyntax.strategy.impl.ReturnActivityStrategy;
import core.basesyntax.strategy.impl.SupplyActivityStrategy;
import java.util.HashMap;
import java.util.Map;

public class ActivityStrategyHandler {
    private static final Map<ActivityType, ActivityStrategy> map;

    static {
        map = new HashMap<>();
        map.put(ActivityType.BALANCE, new BalanceActivityStrategy());
        map.put(ActivityType.SUPPLY, new SupplyActivityStrategy());
        map.put(ActivityType.PURCHASE, new PurchaseActivityStrategy());
        map.put(ActivityType.RETURN, new ReturnActivityStrategy());
    }

    public ActivityStrategy get(ActivityType activityType) {
        if (!map.containsKey(activityType)) {
            throw new UnsupportedActivityException(
                    "Unsupported activity: " + activityType.getCode());
        }
        return map.get(activityType);
    }
}
