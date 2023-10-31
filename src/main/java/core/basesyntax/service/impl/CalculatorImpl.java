package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.CalculatorService;
import core.basesyntax.strategy.FruitHandler;
import core.basesyntax.strategy.FruitHandlerStrategy;
import java.util.List;

public class CalculatorImpl implements CalculatorService {
    private FruitHandlerStrategy fruitHandlerStrategy;

    public CalculatorImpl(FruitHandlerStrategy fruitHandlerStrategy) {
        this.fruitHandlerStrategy = fruitHandlerStrategy;
    }

    public void calculate(List<FruitTransaction> fruitTransactions) {
        fruitTransactions.forEach(fruitTransaction -> {
            FruitHandler handler = fruitHandlerStrategy
                    .getHandler(fruitTransaction.getOperation());
            handler.calculateFruitOperation(fruitTransaction);
        });
    }
}
