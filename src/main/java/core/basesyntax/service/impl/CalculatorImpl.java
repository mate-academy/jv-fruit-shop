package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.Calculator;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationHandlerStrategy;
import java.util.List;

public class CalculatorImpl implements Calculator {
    private OperationHandlerStrategy operationServiceStrategy;

    public CalculatorImpl(OperationHandlerStrategy operationServiceStrategy) {
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
