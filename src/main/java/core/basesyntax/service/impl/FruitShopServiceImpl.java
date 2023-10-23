package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitShopService;
import core.basesyntax.service.strategy.OperationStrategy;
import java.util.List;

public class FruitShopServiceImpl implements FruitShopService {
    private OperationStrategy operationStrategy;

    public FruitShopServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void processingOperations(List<FruitTransaction> fruitTransactions) {
        for (FruitTransaction transaction : fruitTransactions) {
            operationStrategy.getOperationHandler(transaction.getOperation())
                    .handleTransaction(transaction);
        }
    }
}
