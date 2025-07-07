package core.basesyntax.handlers.service.impl;

import core.basesyntax.handlers.OperationStrategy;
import core.basesyntax.handlers.service.ShopService;
import core.basesyntax.model.FruitTransaction;
import java.util.List;

public class ShopServiceImpl implements ShopService {
    private final OperationStrategy operationStrategy;

    public ShopServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void process(List<FruitTransaction> fruitTransactionList) {
        for (FruitTransaction transaction : fruitTransactionList) {
            operationStrategy.get(transaction.getOperation()).apply(transaction);
        }
    }
}
