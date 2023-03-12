package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.StorageCalculator;
import core.basesyntax.strategy.Strategy;
import java.util.List;

public class StorageCalculatorImpl implements StorageCalculator {
    private static final Strategy STRATEGY = new Strategy();

    @Override
    public void calculate(List<FruitTransaction> order) {
        order.stream()
                .forEach(transaction -> STRATEGY.getStrategy(transaction).calculate(transaction));
    }
}
