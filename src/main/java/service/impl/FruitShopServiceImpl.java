package service.impl;

import java.util.List;
import model.FruitTransaction;
import service.FruitShopService;
import strategy.OperationStrategy;

public class FruitShopServiceImpl implements FruitShopService {
    private final OperationStrategy operationStrategy;

    public FruitShopServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void calculate(List<FruitTransaction> parsedData) {

        for (FruitTransaction transaction : parsedData) {
            operationStrategy.get(transaction.getOperation()).handler(transaction);
        }
    }
}
