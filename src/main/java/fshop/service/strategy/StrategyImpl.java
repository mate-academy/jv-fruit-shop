package fshop.service.strategy;

import java.util.Objects;

public class StrategyImpl {
    private Strategy strategy;

    public void setStrategy(Strategy strategy) {
        Objects.requireNonNull(strategy);
        this.strategy = strategy;
    }

    public Integer execute(Integer a, Integer b) {
        return strategy.execute(a, b);
    }
}
