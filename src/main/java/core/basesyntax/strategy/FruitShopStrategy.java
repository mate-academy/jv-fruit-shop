package core.basesyntax.strategy;

import core.basesyntax.dao.FruitShopStorageDao;
import core.basesyntax.dao.StorageDao;
import core.basesyntax.model.FruitTransaction;

public abstract class FruitShopStrategy implements OperationStrategy<FruitTransaction> {
    protected final StorageDao storageDao;

    protected FruitShopStrategy() {
        this.storageDao = new FruitShopStorageDao();
    }

    @Override
    public abstract void apply(FruitTransaction transaction);
}
