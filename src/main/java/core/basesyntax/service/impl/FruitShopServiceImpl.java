package core.basesyntax.service.impl;

import core.basesyntax.model.Transaction;
import core.basesyntax.service.FruitShopService;
import core.basesyntax.strategy.OperationStrategy;
import java.util.List;

public class FruitShopServiceImpl implements FruitShopService {
    private final OperationStrategy operationStrategy;

    public FruitShopServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void runTransaction(List<Transaction> list) {
        for (Transaction fruitTransaction : list) {
            operationStrategy.get(fruitTransaction.getOperation())
                    .process(fruitTransaction);
        }
    }
}
