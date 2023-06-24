package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.CalculatorService;
import core.basesyntax.strategy.impl.StrategyStorageImpl;
import java.util.List;

public class CalculatorServiceImpl implements CalculatorService {
    private final StrategyStorageImpl strategy;

    public CalculatorServiceImpl(StrategyStorageImpl strategy) {
        this.strategy = strategy;
    }

    @Override
    public void calculate(List<FruitTransaction> order) {
        order.stream()
                .forEach(transaction -> strategy.getStrategy(transaction)
                        .handle(transaction));
    }
}
