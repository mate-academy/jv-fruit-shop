package core.basesyntax.strategy.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.CalculationStrategy;
import java.util.List;

public class CalculationStrategyImpl implements CalculationStrategy {
    private final List<CalculationStrategy> strategies;

    public CalculationStrategyImpl(List<CalculationStrategy> strategies) {

        this.strategies = strategies;
    }

    @Override
    public void calculate(FruitTransaction transaction) {
        //todo
    }
}
