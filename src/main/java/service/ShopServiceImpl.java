package service;

import java.util.List;
import model.FruitTransaction;
import service.strategy.OperationStrategy;

public class ShopServiceImpl implements ShopService {
    private final OperationStrategy operationStrategy;

    public ShopServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void process(List<FruitTransaction> transactions) {
        for (FruitTransaction transaction : transactions) {
            operationStrategy.getHandler(transaction.getOperation()).handle(transaction);
        }
    }
}
