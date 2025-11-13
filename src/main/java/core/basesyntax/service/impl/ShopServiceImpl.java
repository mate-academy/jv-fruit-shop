package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ShopService;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import java.util.List;

public class ShopServiceImpl implements ShopService {
    private final OperationStrategy operationStrategy;

    public ShopServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void process(List<FruitTransaction> transactions) {
        if (transactions == null) {
            throw new NullPointerException("Transaction list cannot be null");
        }
        for (FruitTransaction transaction : transactions) {
            if (transaction == null) {
                throw new NullPointerException("There is a null value");
            }
            OperationHandler handler = operationStrategy.get(transaction.getOperation());
            handler.apply(transaction);
        }
    }
}
