package core.basesyntax.service.functionalityexpansion;

import core.basesyntax.db.ChangedData;
import core.basesyntax.service.strategy.ShopActivityStrategy;
import core.basesyntax.service.strategy.ShopBalanceStrategy;
import core.basesyntax.service.strategy.ShopPurchaseStrategy;
import core.basesyntax.service.strategy.ShopReturnStrategy;
import core.basesyntax.service.strategy.ShopSupplyStrategy;
import java.util.Map;

public class FunctionalityExpansionImpl implements FunctionalityExpansion {
    private final ChangedData data;

    public FunctionalityExpansionImpl(ChangedData data) {
        this.data = data;
    }

    @Override
    public void putStrategyByKey(Map<String, ShopActivityStrategy> strategyMap) {
        strategyMap.put("b", new ShopBalanceStrategy(data));
        strategyMap.put("p", new ShopPurchaseStrategy(data));
        strategyMap.put("r", new ShopReturnStrategy(data));
        strategyMap.put("s", new ShopSupplyStrategy(data));
    }
}
