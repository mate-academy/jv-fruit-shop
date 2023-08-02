package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitShopService;
import core.basesyntax.strategy.OperationStrategy;
import java.util.List;

public class FruitShopServiceImpl implements FruitShopService {
    private final OperationStrategy operationStrategy;

    public FruitShopServiceImpl(OperationStrategy operationStrategy) {
        if (operationStrategy == null) {
            throw new RuntimeException("OperationStrategy can`t be null");
        }

        this.operationStrategy = operationStrategy;
    }

    @Override
    public void processStorage(List<FruitTransaction> transactionList) {
        for (FruitTransaction fruitTransaction : transactionList) {
            operationStrategy
                    .get(fruitTransaction.getOperation())
                    .handleOperation(fruitTransaction);
        }
    }

}
