package core.basesyntax.dao.impl;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.db.FruitStorage;
import java.util.Map;
import java.util.Optional;

public class FruitStorageDao implements StorageDao {
    private final FruitStorage storage;

    public FruitStorageDao(FruitStorage storage) {
        this.storage = storage;
    }

    @Override
    public Map<String, Integer> getAll() {
        return storage.getStorage();
    }

    @Override
    public Optional<Integer> getQuantity(String product) {
        return Optional.ofNullable(storage.getStorage().get(product));
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
