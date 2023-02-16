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
    public void transactionProcess(List<FruitTransaction> transactionsList) {
        transactionsList.forEach(fruitTransaction ->
                operationStrategy.get(fruitTransaction.getOperation())
                .handleOperation(fruitTransaction));
    }
}
