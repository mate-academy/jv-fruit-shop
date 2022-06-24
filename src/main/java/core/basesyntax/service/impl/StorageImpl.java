package core.basesyntax.service.impl;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitOperationStrategy;
import core.basesyntax.service.Storage;
import java.util.List;

public class StorageImpl implements Storage {
    private FruitOperationStrategy fruitOperationStrategy;
    private StorageDao storageDao;

    public StorageImpl(FruitOperationStrategy fruitOperationStrategy, StorageDao storageDao) {
        this.fruitOperationStrategy = fruitOperationStrategy;
        this.storageDao = storageDao;
    }

    @Override
    public void fillStorage(List<FruitTransaction> fruitTransactions) {
        for (FruitTransaction fruit: fruitTransactions) {
            fruitOperationStrategy.get(fruit.getOperation())
                    .updateAmount(fruit.getFruit(), fruit.getQuantity());
        }
    }
}
