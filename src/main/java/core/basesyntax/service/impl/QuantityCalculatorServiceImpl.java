package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.QuantityCalculatorService;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationHandlerStrategy;
import java.util.List;

public class QuantityCalculatorServiceImpl implements QuantityCalculatorService {
    private OperationHandlerStrategy operationServiceStrategy;

    public QuantityCalculatorServiceImpl(OperationHandlerStrategy operationServiceStrategy) {
        this.operationServiceStrategy = operationServiceStrategy;
    }

    public void calculate(List<FruitTransaction> fruitTransactions) {
        for (FruitTransaction fruitTransaction : fruitTransactions) {
            OperationHandler handler = operationServiceStrategy
                    .getOperationService(fruitTransaction.getOperation());
            handler.doCalculation(fruitTransaction);
        }
    }
}
