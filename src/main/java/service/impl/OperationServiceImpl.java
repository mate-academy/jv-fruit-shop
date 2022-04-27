package service.impl;

import java.util.List;
import model.FruitTransaction;
import service.OperationHandlerStrategy;
import service.OperationService;
import service.strategy.OperationHandler;

public class OperationServiceImpl implements OperationService {
    private final OperationHandlerStrategy operationHandlerStrategy
            = new OperationHandlerStrategyImpl();

    @Override
    public void calculate(List<FruitTransaction> fruitTransactions) {
        for (FruitTransaction fruitTransaction : fruitTransactions) {
            OperationHandler operationHandler
                    = operationHandlerStrategy.get(fruitTransaction.getOperation());
            operationHandler.apply(fruitTransaction);
        }
    }
}
