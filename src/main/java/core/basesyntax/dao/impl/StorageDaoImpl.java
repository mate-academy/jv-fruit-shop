package core.basesyntax.dao.impl;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.db.FruitStorage;

public class StorageDaoImpl implements StorageDao {
    private final FruitStorage storage;

    public StorageDaoImpl(FruitStorage storage) {
        this.storage = storage;
    }

    @Override
    public Integer readQuantity(String product) {
        return storage.getStorage().get(product);
    }

    @Override
    public void updateProduct(String product, Integer quantity) {
        storage.getStorage().put(product, quantity);
    }

    @Override
    public void deleteProduct(String product) {
        storage.getStorage().remove(product);
    }
}
