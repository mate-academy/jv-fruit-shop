package core.basesyntax.service.impl;

import core.basesyntax.service.QuantityCalculatorService;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationHandlerStrategy;
import core.basesyntax.transaction.FruitTransaction;
import java.util.List;

public class QuantityCalculatorServiceImpl implements QuantityCalculatorService {
    private final OperationHandlerStrategy operationServiceStrategy;

    public QuantityCalculatorServiceImpl(OperationHandlerStrategy operationServiceStrategy) {
        this.operationServiceStrategy = operationServiceStrategy;
    }

    public void calculate(List<FruitTransaction> fruitTransactions) {
        for (FruitTransaction fruitTransaction : fruitTransactions) {
            OperationHandler handler = operationServiceStrategy
                    .getOperationService(fruitTransaction.getOperation());
            handler.handle(fruitTransaction);
        }
    }
}
