package core.basesyntax.service.functionalityexpansion;

import core.basesyntax.db.Storage;
import core.basesyntax.service.strategy.ActivityHandler;
import core.basesyntax.service.strategy.BalanceHandler;
import core.basesyntax.service.strategy.PurchaseHandler;
import core.basesyntax.service.strategy.ReturnHandler;
import core.basesyntax.service.strategy.SupplyHandler;
import java.util.HashMap;
import java.util.Map;

public class ActivityHandlerProvider {
    private final Storage data;
    private final Map<ActivityType, ActivityHandler> strategyMap = new HashMap<>();

    public ActivityHandlerProvider(Storage data) {
        this.data = data;
    }

    public void putStrategyByKey() {
        strategyMap.put(ActivityType.BALANCE, new BalanceHandler(data));
        strategyMap.put(ActivityType.PURCHASE, new PurchaseHandler(data));
        strategyMap.put(ActivityType.RETURN, new ReturnHandler(data));
        strategyMap.put(ActivityType.SUPPLY, new SupplyHandler(data));
    }

    public ActivityHandler getHandler(ActivityType type) {
        return strategyMap.get(type);
    }
}
