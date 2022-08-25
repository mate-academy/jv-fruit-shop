package core.basesyntax.service.strategy.data;

import core.basesyntax.model.TypeActivity;
import core.basesyntax.service.strategy.ActivityBalanceImpl;
import core.basesyntax.service.strategy.ActivityPurchaseImpl;
import core.basesyntax.service.strategy.ActivityReturnImpl;
import core.basesyntax.service.strategy.ActivityStrategy;
import core.basesyntax.service.strategy.ActivitySupplyImpl;
import java.util.HashMap;
import java.util.Map;

public class ActivityToOperation {
    private static final Map<TypeActivity, ActivityStrategy> map = new HashMap<>();

    static {
        map.put(TypeActivity.BALANCE, new ActivityBalanceImpl());
        map.put(TypeActivity.SUPPLY, new ActivitySupplyImpl());
        map.put(TypeActivity.PURCHASE, new ActivityPurchaseImpl());
        map.put(TypeActivity.RETURN, new ActivityReturnImpl());
    }

    public static Map<TypeActivity, ActivityStrategy> getMap() {
        return map;
    }
}
