package service.impl;

import dao.StorageDao;
import java.util.List;
import model.FruitTransaction;
import service.FillStorage;
import service.FruitOperationStrategy;

public class FillStorageImpl implements FillStorage {
    private FruitOperationStrategy fruitOperationStrategy;
    private StorageDao storageDao;

    public FillStorageImpl(FruitOperationStrategy fruitOperationStrategy, StorageDao storageDao) {
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
