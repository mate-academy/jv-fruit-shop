package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitCalculationService;
import core.basesyntax.strategy.CalculatorStrategy;
import java.util.List;

public class FruitCalculationServiceImpl implements FruitCalculationService {
    private final CalculatorStrategy strategy;

    public FruitCalculationServiceImpl(CalculatorStrategy strategy) {
        this.strategy = strategy;
    }

    @Override
    public void addToStorage(List<FruitTransaction> transactions) {
        for (FruitTransaction transaction : transactions) {
            strategy.calculate(transaction);
        }
    }
}
