package core.basesyntax.impl;

import core.basesyntax.db.FruitShopStorage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FillFruitShopStorage;
import core.basesyntax.service.GetOperationStrategy;
import java.util.List;

public class FillFruitShopStorageImpl implements FillFruitShopStorage {
    private final GetOperationStrategy getOperationStrategy;
    private final FruitShopStorage fruitShopStorage;

    public FillFruitShopStorageImpl(
            GetOperationStrategy getOperationStrategy,
            FruitShopStorage fruitShopStorage) {
        this.getOperationStrategy = getOperationStrategy;
        this.fruitShopStorage = fruitShopStorage;
    }

    @Override
    public FruitShopStorage fillFruitShopStorage(List<FruitTransaction> fruitTransactionList) {
        for (FruitTransaction fruitTransaction : fruitTransactionList) {
            getOperationStrategy.getOperationStrategy(fruitTransaction.getOperation())
                    .transferToStorage(fruitTransaction);
        }
        return fruitShopStorage;
    }
}
