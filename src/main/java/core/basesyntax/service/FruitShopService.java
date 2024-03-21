package core.basesyntax.service;

import core.basesyntax.service.functionalityexpansion.ActivityHandlerProvider;
import core.basesyntax.service.parsefileinfo.FruitInfo;
import core.basesyntax.service.strategy.ActivityHandler;
import java.util.List;

public class FruitShopService {
    public void execute(List<FruitInfo> fruits, ActivityHandlerProvider activityProvider) {
        for (FruitInfo fruit : fruits) {
            ActivityHandler strategy = activityProvider.getHandler(fruit.activityType());
            strategy.operate(fruit.name(), fruit.quantity());
        }
    }
}
