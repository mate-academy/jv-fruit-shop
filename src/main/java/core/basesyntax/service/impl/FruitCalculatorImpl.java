package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitCalculator;
import core.basesyntax.strategy.CalculateStrategy;
import core.basesyntax.strategy.impl.CalculateStrategyImpl;
import java.util.List;

public class FruitCalculatorImpl implements FruitCalculator {
    private static final CalculateStrategy CALCULATE_STRATEGY = new CalculateStrategyImpl();

    @Override
    public void calculateTotalQuantity(List<FruitTransaction> transactions) {
        for (FruitTransaction fruitTransaction: transactions) {
            CALCULATE_STRATEGY.getHandler(fruitTransaction)
                    .calculateAndAddToStorage(fruitTransaction);
        }
    }
}
