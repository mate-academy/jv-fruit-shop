package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.Calculator;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import java.util.List;

public class CalculatorImpl implements Calculator {
    private OperationStrategy operationServiceStrategy;

    public CalculatorImpl(OperationStrategy operationServiceStrategy) {
        this.operationServiceStrategy = operationServiceStrategy;
    }

    public void calculate(List<FruitTransaction> fruitTransactions) {
        fruitTransactions.forEach(fruitTransaction -> {
            OperationHandler handler = operationServiceStrategy
                    .getOperationService(fruitTransaction.getOperation());
            handler.calculate(fruitTransaction);
        });
    }
}
