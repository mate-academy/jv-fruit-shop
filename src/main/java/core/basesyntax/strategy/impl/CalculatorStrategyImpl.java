package core.basesyntax.strategy.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.CalculatorStrategy;
import core.basesyntax.strategy.TypeCalculatorStrategy;
import java.util.List;

public class CalculatorStrategyImpl implements CalculatorStrategy {
    private final List<TypeCalculatorStrategy> strategies;

    public CalculatorStrategyImpl(List<TypeCalculatorStrategy> strategies) {
        this.strategies = strategies;
    }

    @Override
    public void calculate(FruitTransaction transaction) {
        strategies.stream()
                .filter(k -> k.test(transaction.getOperation()))
                .findFirst()
                .get()
                .calculate(transaction);
    }
}
