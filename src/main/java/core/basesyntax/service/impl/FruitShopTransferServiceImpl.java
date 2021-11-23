package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitShopTransferService;
import core.basesyntax.strategy.OperationStrategy;
import java.util.List;

public class FruitShopTransferServiceImpl implements FruitShopTransferService {
    private final OperationStrategy operationStrategy;

    public FruitShopTransferServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    public void updateStorageInfo(List<FruitTransaction> fruitTransactions) {
        for (FruitTransaction fruitTransaction : fruitTransactions) {
            operationStrategy
                    .get(fruitTransaction.getOperation())
                    .apply(fruitTransaction);
        }
    }
}
