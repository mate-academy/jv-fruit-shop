package service.impl;

import db.Storage;
import java.util.List;
import model.FruitTransaction;
import service.ShopService;
import strategy.OperationHandler;
import strategy.OperationStrategy;

public class ShopServiceImpl implements ShopService {
    private final OperationStrategy operationStrategy;

    public ShopServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void process(List<FruitTransaction> transactions) {
        if (transactions == null || transactions.isEmpty()) {
            return;
        }

        for (FruitTransaction transaction : transactions) {
            OperationHandler handler = operationStrategy
                    .getHandler(transaction.getOperation());

            if (handler != null) {
                handler.operate(Storage.getFruits(), transaction);
            }
        }
    }
}
