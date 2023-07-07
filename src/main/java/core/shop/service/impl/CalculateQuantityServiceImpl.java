package core.shop.service.impl;

import core.shop.handler.strategy.OperationStrategy;
import core.shop.model.FruitTransaction;
import core.shop.service.CalculateQuantityService;
import java.util.List;

public class CalculateQuantityServiceImpl implements CalculateQuantityService {
    private final OperationStrategy operationStrategy;

    public CalculateQuantityServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void calculate(List<FruitTransaction> fruitTransactions) {
        for (FruitTransaction fruitTransaction : fruitTransactions) {
            operationStrategy.getOperationHandler(fruitTransaction.getOperationType())
                    .operation(fruitTransaction);
        }
    }
}
