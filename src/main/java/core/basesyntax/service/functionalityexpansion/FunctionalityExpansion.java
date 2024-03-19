package core.basesyntax.service.functionalityexpansion;

import core.basesyntax.service.strategy.ShopActivityStrategy;
import java.util.Map;

public interface FunctionalityExpansion {
    void putStrategyByKey(Map<String, ShopActivityStrategy> strategyMap);
}
