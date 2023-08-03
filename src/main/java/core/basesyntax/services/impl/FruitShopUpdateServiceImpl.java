package core.basesyntax.services.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.services.FruitShopUpdateService;
import core.basesyntax.strategy.OperationStrategy;
import java.util.List;

public class FruitShopUpdateServiceImpl implements FruitShopUpdateService<FruitTransaction> {
    private final OperationStrategy operationStrategy;

    public FruitShopUpdateServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void update(List<FruitTransaction> fruitTransactions) {
        for (FruitTransaction fruitTransaction : fruitTransactions) {
            operationStrategy.get(fruitTransaction.getOperation())
                    .operate(fruitTransaction);
        }
    }
}
