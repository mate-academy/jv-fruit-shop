package service.impl;

import java.util.List;
import model.FruitTransaction;
import service.FruitShopService;
import strategy.OperationHandler;
import strategy.OperatorStrategy;

public class FruitShopServiceImpl implements FruitShopService {
    private OperatorStrategy operationStrategy;

    public FruitShopServiceImpl(OperatorStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void processTransactions(List<FruitTransaction> transactions) {
        for (FruitTransaction transaction : transactions) {
            OperationHandler operationHandler = operationStrategy.getHandler(transaction);
            operationHandler.operateFruits(transaction);
        }
    }
}
