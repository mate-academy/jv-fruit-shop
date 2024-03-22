package core.basesyntax.service.functionalityexpansion;

import core.basesyntax.db.Storage;
import core.basesyntax.service.strategy.ActivityHandler;
import core.basesyntax.service.strategy.BalanceHandler;
import core.basesyntax.service.strategy.PurchaseHandler;
import core.basesyntax.service.strategy.ReturnHandler;
import core.basesyntax.service.strategy.SupplyHandler;
import java.util.Map;

public class ActivityHandlerProvider {
    private final Map<ActivityType, ActivityHandler> strategyMap;

    public ActivityHandlerProvider(Storage storage) {
        strategyMap = Map.of(
                ActivityType.BALANCE, new BalanceHandler(storage),
                ActivityType.PURCHASE, new PurchaseHandler(storage),
                ActivityType.RETURN, new ReturnHandler(storage),
                ActivityType.SUPPLY, new SupplyHandler(storage)
        );
    }

    public ActivityHandler getHandler(ActivityType type) {
        return strategyMap.get(type);
    }
}
