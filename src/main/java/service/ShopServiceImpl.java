package service;

import core.basesyntax.FruitTransaction;
import java.util.List;
import strategy.OperationStrategy;

public class ShopServiceImpl implements ShopService {
    private OperationStrategy operationStrategy;

    public ShopServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void process(List<FruitTransaction> transactions) {
        for (FruitTransaction transaction : transactions) {
            var handler = operationStrategy.get(transaction.getOperation());
            handler.handle(transaction);
        }
    }
}
