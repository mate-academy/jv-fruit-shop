package service.impl;

import java.util.List;
import model.FruitTransaction;
import service.OperationHandlerStrategy;
import service.OperationService;

public class OperationServiceImpl implements OperationService {
    private final OperationHandlerStrategy operationHandlerStrategy;

    public OperationServiceImpl() {
        operationHandlerStrategy = new OperationHandlerStrategyImpl();
    }

    @Override
    public void calculate(List<FruitTransaction> fruitTransactions) {
        fruitTransactions.forEach(i -> operationHandlerStrategy
                .get(i.getOperation()).apply(i));
    }
}
