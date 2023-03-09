package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.CalculationFruits;
import core.basesyntax.strategy.CalculationStrategy;
import java.util.List;

public class CalculationFruitsImpl implements CalculationFruits {
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
