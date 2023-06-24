package core.basesyntax.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.operationstrategy.OperationStrategy;
import core.basesyntax.service.FruitShopService;
import java.util.List;

public class FruitShopServiceImpl implements FruitShopService {
    private final OperationStrategy operationStrategy;

    public FruitShopServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void processTransactions(List<FruitTransaction> transactionsList) {
        for (FruitTransaction fruitTransaction : transactionsList) {
            operationStrategy.handleOperation(fruitTransaction);
        }
    }
}
