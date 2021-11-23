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

    public void updateStorageInfo(List<FruitTransaction> fruitStorages) {
        for (FruitTransaction fruitTransaction : fruitStorages) {
            operationStrategy
                    .get(fruitTransaction.getOperation())
                    .apply(fruitTransaction);
        }
    }
}
