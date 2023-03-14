package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.CalculatorService;
import core.basesyntax.strategy.Strategy;
import java.util.List;

public class CalculatorServiceImpl implements CalculatorService {
    private static final Strategy STRATEGY = new Strategy();

    @Override
    public void calculate(List<FruitTransaction> order) {
        order.stream()
                .forEach(transaction -> STRATEGY.getStrategy(transaction).calculate(transaction));
    }
}
