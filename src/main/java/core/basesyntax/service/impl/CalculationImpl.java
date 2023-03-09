package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.Calculation;
import core.basesyntax.strategy.CalculationStrategy;
import java.util.List;

public class CalculationImpl implements Calculation {
    private static final CalculationStrategy CALCULATION_STRATEGY = new CalculationStrategy();

    @Override
    public void calculation(List<FruitTransaction> parsedString) {
        for (FruitTransaction fruitTransaction : parsedString) {
            CALCULATION_STRATEGY
                    .getCalculationServiceByLetter(fruitTransaction)
                    .transaction(fruitTransaction);
        }
    }
}
