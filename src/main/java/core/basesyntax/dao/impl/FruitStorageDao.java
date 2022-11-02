package core.basesyntax.dao.impl;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.db.FruitStorage;

public class FruitStorageDao implements StorageDao {
    private final FruitStorage storage;

    public FruitStorageDao(FruitStorage storage) {
        this.storage = storage;
    }

    @Override
    public Integer getQuantity(String product) {
        return storage.getStorage().get(product);
    }

    @Override
    public void update(String product, Integer quantity) {
        storage.getStorage().put(product, quantity);
    }

    @Override
    public void delete(String product) {
        storage.getStorage().remove(product);
    }
}
