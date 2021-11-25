package core.basesyntax.strategy;

import core.basesyntax.service.activities.Handler;
import java.util.Map;

public class StoreStrategyImpl implements StoreStrategy {
    private Map<String, Handler> strategyMap;

    public StoreStrategyImpl(Map<String, Handler> strategyMap) {
        this.strategyMap = strategyMap;
    }

    @Override
    public Handler get(String letter) {
        return strategyMap.get(letter);
    }
}
