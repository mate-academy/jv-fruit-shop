package core.basesyntax.impl;

import core.basesyntax.db.FruitShopStorage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationStrategy;
import core.basesyntax.service.ProcessFruitShopStorage;
import java.util.List;

public class ProcessFruitShopStorageImpl implements ProcessFruitShopStorage {
    private final OperationStrategy getOperationStrategy;
    private final FruitShopStorage fruitShopStorage;

    public ProcessFruitShopStorageImpl(
            OperationStrategy getOperationStrategy,
            FruitShopStorage fruitShopStorage) {
        this.getOperationStrategy = getOperationStrategy;
        this.fruitShopStorage = fruitShopStorage;
    }

    @Override
    public FruitShopStorage fillFruitShopStorage(List<FruitTransaction> fruitTransactionList) {
        for (FruitTransaction fruitTransaction : fruitTransactionList) {
            getOperationStrategy.getOperationStrategy(fruitTransaction.getOperation())
                    .handle(fruitTransaction);
        }
        return fruitShopStorage;
    }
}
