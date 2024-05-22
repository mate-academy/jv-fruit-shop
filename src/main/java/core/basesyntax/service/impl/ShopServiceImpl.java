package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ShopService;
import core.basesyntax.strategy.OperationStrategy;
import java.util.List;

public class ShopServiceImpl implements ShopService {
    private static OperationStrategy operationStrategy;

    public ShopServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void operation(List<FruitTransaction> fruitTransactions) {
        fruitTransactions.forEach(
                fruitTransaction -> operationStrategy.getOperation(fruitTransaction.getOperation())
                        .operation(fruitTransaction)
        );
    }
}
