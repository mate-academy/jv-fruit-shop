package core.basesyntax.impl;

import java.util.List;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.operationStrategy.OperationStrategy;
import core.basesyntax.service.FruitShopService;

public class FruitShopServiceImpl implements FruitShopService {
    private final OperationStrategy operationStrategy;

    public FruitShopServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void transactionProcess(List<FruitTransaction> transactionsList) {
        for (FruitTransaction fruitTransaction : transactionsList) {
            operationStrategy.get(fruitTransaction.getOperation()).handleOperation(fruitTransaction);
        }
    }
}
