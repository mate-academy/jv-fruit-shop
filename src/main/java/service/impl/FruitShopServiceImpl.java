package service.impl;

import java.util.List;
import model.FruitTransaction;
import service.FruitShopService;
import strategy.OperationStrategy;
import strategy.OperationStrategyImpl;

public class FruitShopServiceImpl implements FruitShopService {
    private OperationStrategy operationStrategy;

    public FruitShopServiceImpl() {
        operationStrategy = new OperationStrategyImpl();
    }

    @Override
    public void processOfOperations(List<FruitTransaction> fruitTransactions) {
        for (FruitTransaction fruitTransaction : fruitTransactions) {
            operationStrategy.get(fruitTransaction.getOperation()).handle(fruitTransaction);
        }
    }
}
