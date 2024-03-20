package core.basesyntax.service.functionalityexpansion;

import core.basesyntax.db.CurrentData;
import core.basesyntax.service.strategy.ShopActivityStrategy;
import core.basesyntax.service.strategy.ShopBalanceStrategy;
import core.basesyntax.service.strategy.ShopPurchaseStrategy;
import core.basesyntax.service.strategy.ShopReturnStrategy;
import core.basesyntax.service.strategy.ShopSupplyStrategy;
import java.util.Map;

public class FunctionalityExpansion {
    private final CurrentData data;

    public FunctionalityExpansion(CurrentData data) {
        this.data = data;
    }

    public void putStrategyByKey(Map<ActivityTypeEnum, ShopActivityStrategy> strategyMap) {
        strategyMap.put(ActivityTypeEnum.BALANCE, new ShopBalanceStrategy(data));
        strategyMap.put(ActivityTypeEnum.PURCHASE, new ShopPurchaseStrategy(data));
        strategyMap.put(ActivityTypeEnum.RETURN, new ShopReturnStrategy(data));
        strategyMap.put(ActivityTypeEnum.SUPPLY, new ShopSupplyStrategy(data));
    }
}
