package service.impl;

import java.util.List;
import model.FruitTransaction;
import service.FruitShopService;
import strategy.OperationHandler;
import strategy.impl.OperatorStrategyImpl;

public class FruitShopServiceImpl implements FruitShopService {

    @Override
    public void startFruitsOperations(List<FruitTransaction> transactions) {
        OperatorStrategyImpl operationStrategy = new OperatorStrategyImpl();
        for (FruitTransaction transaction : transactions) {
            OperationHandler operationHandler = operationStrategy.getHandler(transaction);
            operationHandler.operateFruits(transaction);
        }
    }
}
