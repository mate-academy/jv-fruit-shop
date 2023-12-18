package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.StockService;
import core.basesyntax.strategy.ActivityStrategy;
import java.util.List;

public class StockServiceImpl implements StockService {
    private ActivityStrategy activityStrategy;

    public StockServiceImpl(ActivityStrategy activityStrategy) {
        this.activityStrategy = activityStrategy;
    }

    @Override
    public void calculateStock(List<FruitTransaction> fruitTransactions) {
        for (FruitTransaction fruitTransaction : fruitTransactions) {
            activityStrategy.get(fruitTransaction
                    .getOperation()).updateBalance(fruitTransaction);
        }
    }
}
