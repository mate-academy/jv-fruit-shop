package service.impl;

import database.StorageDealer;
import java.util.List;
import model.FruitTransaction;
import service.ShopService;
import strategy.OperationHandler;
import strategy.OperationStrategy;

public class ShopServiceImpl implements ShopService {
    private final OperationStrategy operationStrategy;
    private final StorageDealer storageDealer;

    public ShopServiceImpl(OperationStrategy operationStrategy, StorageDealer storageDealer) {
        this.operationStrategy = operationStrategy;
        this.storageDealer = storageDealer;
    }

    @Override
    public void process(List<FruitTransaction> fruitTransactions) {
        for (FruitTransaction transaction : fruitTransactions) {
            OperationHandler handler = getHandler(transaction);
            String fruit = transaction.getFruit();
            int quantity = handler.getQuantityToCalculate(transaction);
            storageDealer.updateDatabase(fruit, quantity);
        }
    }

    private OperationHandler getHandler(FruitTransaction transaction) {
        return operationStrategy.getOperationHandler(transaction.getOperation());
    }
}
