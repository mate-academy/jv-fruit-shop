package core.basesyntax.service.strategy;

import core.basesyntax.service.strategy.impl.BalanceService;
import core.basesyntax.service.strategy.impl.PurchaseService;
import core.basesyntax.service.strategy.impl.ReturnService;
import core.basesyntax.service.strategy.impl.SupplyService;
import core.basesyntax.utility.FruitTransaction;

public class ActivityStrategy {
    public ActivityService getActivityService(FruitTransaction.Operation activityType) {
        return switch (activityType) {
            case RETURN -> new ReturnService();
            case SUPPLY -> new SupplyService();
            case BALANCE -> new BalanceService();
            case PURCHASE -> new PurchaseService();
        };
    }
}
