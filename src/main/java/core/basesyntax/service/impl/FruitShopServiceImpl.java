package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitShopService;
import core.basesyntax.service.strategy.OperationStrategy;
import java.util.List;

public class FruitShopServiceImpl implements FruitShopService {
    private final OperationStrategy operationStrategy;

    public FruitShopServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public boolean processData(List<FruitTransaction> transactionList) {
        boolean isProcessed = false;
        for (FruitTransaction fruitTransaction : transactionList) {
            operationStrategy.processOperation(fruitTransaction.getOperationType())
                    .applyOperation(fruitTransaction);
            isProcessed = true;
        }
        return isProcessed;
    }
}
