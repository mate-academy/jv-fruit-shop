package service.impl;

import model.FruitTransaction;
import service.OperationHandlerStrategy;
import service.OperationService;
import service.strategy.OperationHandler;
import java.util.List;

public class OperationServiceImpl implements OperationService {
    private final OperationHandlerStrategy operationHandlerStrategy = new OperationHandlerStrategyImpl();

    @Override
    public void calculate(List<FruitTransaction> fruitTransactions) {
        for (FruitTransaction fruitTransaction : fruitTransactions) {
            OperationHandler operationHandler = operationHandlerStrategy.get(fruitTransaction.getOperation());
            operationHandler.apply(fruitTransaction);
        }
    }
}
