package service.impl;

import java.util.List;
import model.FruitTransaction;
import service.ActivityStrategy;
import service.ShopService;

public class ShopServiceImpl implements ShopService {
    private ActivityStrategy strategy;

    public ShopServiceImpl(ActivityStrategy strategy) {
        this.strategy = strategy;
    }

    @Override
    public boolean processTransactions(List<FruitTransaction> transactions) {
        transactions.forEach(t -> strategy.getHandler(t.getOperation()).handle(t));
        return true;
    }
}
