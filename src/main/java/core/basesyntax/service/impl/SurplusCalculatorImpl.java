package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.SurplusCalculator;
import core.basesyntax.service.strategy.OperationStrategy;
import java.util.List;

public class SurplusCalculatorImpl implements SurplusCalculator {

    @Override
    public void calculateData(List<FruitTransaction> fruitTransactions) {
        fruitTransactions.forEach(fruitTransaction ->
                new OperationStrategy().getOperation(fruitTransaction)
                        .performOperation(fruitTransaction));
    }
}
