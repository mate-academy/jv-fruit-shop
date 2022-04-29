package service.impl;

import java.util.List;
import model.FruitTransaction;
import service.OperationHandlerStrategy;
import service.OperationService;

public class OperationServiceImpl implements OperationService {
    private final OperationHandlerStrategy operationHandlerStrategy;

    public OperationServiceImpl(OperationHandlerStrategy operationHandlerStrategy) {
        this.operationHandlerStrategy = operationHandlerStrategy;
    }

    @Override
    public void calculate(List<FruitTransaction> fruitTransactions) {
        fruitTransactions.forEach(i -> operationHandlerStrategy
                .get(i.getOperation()).apply(i));
    }
}
