package core.basesyntax.services.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.services.FruitShopUpdateService;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.handlers.OperationHandler;
import java.util.List;
import java.util.Map;

public class FruitShopUpdateServiceImpl implements FruitShopUpdateService<FruitTransaction> {
    private final OperationStrategy operationStrategy;

    public FruitShopUpdateServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void update(List<FruitTransaction> fruitTransactions,
                       Map<FruitTransaction.OperationType, OperationHandler> map) {
        for (FruitTransaction fruitTransaction : fruitTransactions) {
            operationStrategy.get(fruitTransaction.getOperation(), map)
                    .operate(fruitTransaction);
        }
    }
}
