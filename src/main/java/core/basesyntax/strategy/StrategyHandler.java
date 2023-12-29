package core.basesyntax.strategy;

import java.util.Map;

public class StrategyHandler {
    private Strategy strategy;

    public StrategyHandler(Strategy strategy) {
        this.strategy = strategy;
    }

    public int performCountBalance(String fruit, String quantity, Map<String, String> map) {
        return strategy.countBalance(fruit, quantity, map);
    }
}
