package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitShopService;
import core.basesyntax.service.strategy.OperationStrategy;
import java.util.List;

public class FruitShopServiceImpl implements FruitShopService<FruitTransaction> {
    private final OperationStrategy operationStrategy;

    public FruitShopServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void update(List<FruitTransaction> fruitTransactions) {
        checkFruitTransactionsForNull(fruitTransactions);
        for (FruitTransaction fruitTransaction : fruitTransactions) {
            operationStrategy.getOperationHandler(fruitTransaction.getOperation())
                    .process(fruitTransaction);
        }
    }

    private void checkFruitTransactionsForNull(List<FruitTransaction> fruitTransactions) {
        if (fruitTransactions == null) {
            throw new RuntimeException("The input list of fruit transactions is null!");
        }
    }
}
