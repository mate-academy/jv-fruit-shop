package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitCalculator;
import core.basesyntax.strategy.CalculationStrategy;
import java.util.List;

public class FruitCalculatorImpl implements FruitCalculator {
    private static final CalculationStrategy CALCULATION_STRATEGY = new CalculationStrategy();

    @Override
    public void calculate(List<FruitTransaction> parsedString) {
        for (FruitTransaction fruitTransaction : parsedString) {
            CALCULATION_STRATEGY
                    .getCalculationServiceByLetter(fruitTransaction)
                    .transaction(fruitTransaction);
        }
    }
}
