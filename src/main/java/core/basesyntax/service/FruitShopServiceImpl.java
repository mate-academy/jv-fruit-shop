package core.basesyntax.service;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationStrategy;

public class FruitShopServiceImpl implements FruitShopService {
    private final OperationStrategy operationStrategy;

    public FruitShopServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void processStorage() {
        for (FruitTransaction fruitTransaction : Storage.transactionStorage) {
            operationStrategy
                    .get(fruitTransaction.getOperation())
                    .handleOperation(fruitTransaction);
        }
    }

}
