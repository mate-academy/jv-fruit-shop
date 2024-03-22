package core.basesyntax.service;

import core.basesyntax.service.functionalityexpansion.ActivityHandlerProvider;
import core.basesyntax.service.parsefileinfo.FruitTransactionInfo;
import core.basesyntax.service.strategy.ActivityHandler;
import java.util.List;

public class FruitShopService {
    private final ActivityHandlerProvider activityProvider;

    public FruitShopService(ActivityHandlerProvider activityProvider) {
        this.activityProvider = activityProvider;
    }

    public void execute(List<FruitTransactionInfo> fruits) {
        for (FruitTransactionInfo fruit : fruits) {
            ActivityHandler handler = activityProvider.getHandler(fruit.activityType());
            handler.operate(fruit.name(), fruit.quantity());
        }
    }
}
