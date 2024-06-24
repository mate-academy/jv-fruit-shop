package service.impl;

import java.util.List;
import model.FruitTransaction;
import service.ShopService;
import strategy.OperationStrategy;

public class ShopServiceImpl implements ShopService {
    private final OperationStrategy strategy;

    public ShopServiceImpl(OperationStrategy strategy) {
        this.strategy = strategy;
    }

    @Override
    public void process(List<FruitTransaction> transactions) {
        transactions.forEach(transaction ->
                strategy.get(transaction.getOperation()).applyOperation(transaction));
    }
}
