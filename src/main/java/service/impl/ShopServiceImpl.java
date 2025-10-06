package service.impl;

import java.util.List;
import model.FruitTransaction;
import service.ShopService;
import strategy.OperationHandler;
import strategy.OperationStrategy;

public class ShopServiceImpl implements ShopService {

    private final OperationStrategy strategy;

    public ShopServiceImpl(OperationStrategy strategy) {
        this.strategy = strategy;
    }

    @Override
    public void process(List<FruitTransaction> transactions) {
        if (transactions == null) {
            throw new IllegalArgumentException("Transactions null");
        }

        for (FruitTransaction transaction : transactions) {
            if (transaction == null) {
                throw new IllegalArgumentException("Null transaction");
            }
            OperationHandler handler = strategy.getHandler(transaction.getOperation());
            handler.apply(transaction);
        }
    }
}
